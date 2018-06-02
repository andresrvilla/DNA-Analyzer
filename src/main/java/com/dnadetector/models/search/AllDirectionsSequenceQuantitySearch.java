package com.dnadetector.models.search;

import com.dnadetector.interfaces.search.ISecuenceQuantitySearch;

public class AllDirectionsSequenceQuantitySearch implements ISecuenceQuantitySearch {
    public int QuantitySearch(String[] dna, String sequence) {
        int times = 0;

        for (int i = 0; i < dna.length; i++) {
            //Busco las ocurrencias horizontales
            if (dna[i].contains(sequence))
                times++;

            //Compongo la diagonal vertical
            String sequenceToAnalyze = "";
            for (int j = 0; j < dna.length; j++) {
                sequenceToAnalyze += dna[j].charAt(i);
            }

            //Busco las ocurrencias verticales
            if (sequenceToAnalyze.contains(sequence))
                times++;
        }

        //La diferencia entre la dimension de la matriz y el largo de la secuencia
        //me sirve para el rango en x  e y que tengo que recorrer de las diagonales
        //Utilizo este rango calculado para evitar algunos bucles del for que serian innecesarios
        int lengthDifference = dna.length - sequence.length();

        //Busco las ocurrencias en la diagonal inferior y diagonal central, de arriba para abajo
        for (int i = lengthDifference; i >= 0; i--) {
            String sequenceToAnalyze = "";
            for (int j = 0; j < dna.length - i; j++) {
                sequenceToAnalyze += dna[i + j].charAt(j);
            }
            if (sequenceToAnalyze.contains(sequence))
                times++;
        }
        //Busco las ocurrencias en la diagonal superior, de arriba para abajo
        for (int i = 1; i <= lengthDifference; i++) {
            String sequenceToAnalyze = "";
            for (int j = 0; j < dna.length - i; j++) {
                sequenceToAnalyze += dna[j].charAt(i + j);
            }
            if (sequenceToAnalyze.contains(sequence))
                times++;
        }


        //Busco las ocurrencias en la diagonal inferior y diagonal central, de abajo para arriba
        for (int i = lengthDifference + 1; i < dna.length; i++) {
            String sequenceToAnalyze = "";
            for (int j = 0; j <= i; j++) {
                sequenceToAnalyze += dna[i - j].charAt(j);
            }
            if (sequenceToAnalyze.contains(sequence))
                times++;
        }

        //Busco las ocurrencias en la diagonal superior, de abajo para arriba
        for (int i = 0; i < lengthDifference; i++) {
            String sequenceToAnalyze = "";

            for (int j = i + 1; j < dna.length; j++) {
                sequenceToAnalyze += dna[dna.length - j + i].charAt(j);
            }

            if (sequenceToAnalyze.contains(sequence))
                times++;
        }
        return times;

    }
}
