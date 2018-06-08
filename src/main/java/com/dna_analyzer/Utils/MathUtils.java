package com.dna_analyzer.Utils;

public class MathUtils {
    public static double roundTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
