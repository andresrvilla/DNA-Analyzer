package com.dna_analyzer.services;

import com.dna_analyzer.Utils.MathUtils;
import com.dna_analyzer.data.exceptions.DNADataException;
import com.dna_analyzer.data.interfaces.IDNAData;
import com.dna_analyzer.models.DNA;
import com.dna_analyzer.services.analysis.IDNAAnalyzer;
import com.dna_analyzer.services.analysis.IDNAAnalyzerStats;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DNAMagnetoBussiness {
    //HC
    String[] mutantSequences = {"AAAA", "TTTT", "CCCC", "GGGG"};
    int minQuantity = 2;
    private IDNAData idnaData;
    private IDNAAnalyzer idnaAnalyzer;
    private IDNAAnalyzerStats idnaAnalyzerStats;

    public DNAMagnetoBussiness(IDNAData idnaData,
                               IDNAAnalyzer idnaAnalyzer,
                               IDNAAnalyzerStats idnaAnalyzerStats) {
        this.idnaAnalyzer = idnaAnalyzer;
        this.idnaAnalyzerStats = idnaAnalyzerStats;
        this.idnaData = idnaData;
    }

    public boolean isMutant(DNA Dna) throws DNADataException, ClassNotFoundException {
        int times = 0;

        for (int i = 0; i < mutantSequences.length; i++) {
            times += idnaAnalyzer.QuantitySearch(Dna, mutantSequences[i]);
        }

        Boolean isMutant = times >= minQuantity;

        ArrayList<String> statsToUpdate = new ArrayList<String>();
        if (isMutant) {
            statsToUpdate.add("count_mutant_dna");
        } else {
            statsToUpdate.add("count_human_dna");
        }

        idnaData.InsertDNA(Dna.toString(), statsToUpdate);

        return isMutant;
    }

    public JSONObject stats() throws DNADataException, JSONException, ClassNotFoundException {
        HashMap<String, Long> stats = idnaAnalyzerStats.getStats();
        JSONObject result = new JSONObject();
        Iterator it = stats.entrySet().iterator();
        long min = Long.MAX_VALUE;
        while (it.hasNext()) {
            Map.Entry<String, Long> pair = (Map.Entry) it.next();
            result.put(pair.getKey(), pair.getValue());
            //Obtengo el valor minimo para generar el ratio
            if (pair.getValue() < min)
                min = pair.getValue();
        }

        //recorro nuevamente para generar el ratio en el caso de que sea mayor a dos los valores.
        //Si es son dos los valores, se calcula distinto
        if (stats.size() != 2 && min > 0) {
            it = stats.entrySet().iterator();
            String ratio = "";
            while (it.hasNext()) {
                Map.Entry<String, Long> pair = (Map.Entry) it.next();
                //divido el valor por el minimo para obtener cada ratio
                ratio += MathUtils.roundTwoDecimals((pair.getValue() / min)) + ":";
            }
            result.put("ratio", ratio.substring(0, ratio.length() - 1));
        } else if (stats.size() != 2 && min == 0) {
            result.put("ratio", "undefined");
        } else {
            float first = 0;
            float second = 0;
            it = stats.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Long> pair = (Map.Entry) it.next();
                //divido el valor por el minimo para obtener cada ratio
                if (pair.getKey() == "count_mutant_dna")
                    first = pair.getValue();
                else
                    second = pair.getValue();
            }

            result.put("ratio", MathUtils.roundTwoDecimals(first / second));
        }


        return result;
    }
}
