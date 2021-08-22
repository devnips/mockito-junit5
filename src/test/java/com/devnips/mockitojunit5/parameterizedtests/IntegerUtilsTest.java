package com.devnips.mockitojunit5.parameterizedtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void test_odd_numbers(int value) {
        Assertions.assertTrue(IntegerUtils.isOdd(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 1000, -30, 150, (Integer.MAX_VALUE - 1)})
    void test_even_numbers(int value) {
        Assertions.assertFalse(IntegerUtils.isOdd(value));
    }
}