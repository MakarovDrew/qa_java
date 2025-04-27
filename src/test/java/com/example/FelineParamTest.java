package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int input;
    private final int expected;

    public FelineParamTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, 2},
                {3, 3}
        };
    }

    @Test
    public void testGetKittensWithParam() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(input));
    }
}