package com.devnips.mockitojunit5.service;

/**
 * A simple calculator class, with no external dependencies.
 */
public class SimpleCalculator {

    /**
     * Calculate sum of two numbers and return the calculates sum as response.
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        return a + b;
    }
}
