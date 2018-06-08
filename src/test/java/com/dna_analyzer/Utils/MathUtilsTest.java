package com.dna_analyzer.Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilsTest {

    @Test
    void roundTwoDecimalsShouldReturnSimpleDecimalRounded() {
        double in = 3.5432345691;
        assertEquals(MathUtils.roundTwoDecimals(in), 3.54);
        in = 3.5492345691;
        assertEquals(MathUtils.roundTwoDecimals(in), 3.55);
    }
}