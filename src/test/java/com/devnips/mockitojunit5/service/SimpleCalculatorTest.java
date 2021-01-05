package com.devnips.mockitojunit5.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A simple JUnit test
 */
class SimpleCalculatorTest {

    private final SimpleCalculator simpleCalculator = new SimpleCalculator();

    @Test
    void test_add() {
        Assertions.assertEquals(6, simpleCalculator.add(2, 4));
    }
}