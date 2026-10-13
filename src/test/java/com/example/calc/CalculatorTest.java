package com.example.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void addsNumbers() {
        assertEquals(5.0, calc.add(2, 3));
    }

    @Test
    void subtractsNumbers() {
        assertEquals(-1.0, calc.subtract(2, 3));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(6.0, calc.multiply(2, 3));
    }

    @Test
    void dividesNumbers() {
        assertEquals(2.5, calc.divide(5, 2));
    }

    @Test
    void divisionByZeroThrows() {
        assertThrows(ArithmeticException.class, () -> calc.divide(1, 0));
    }
}
