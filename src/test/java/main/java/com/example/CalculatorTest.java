package main.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    void testSub() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMul() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testDiv() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testDivByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testMod() {
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testPow() {
        assertEquals(100, calculator.calculate(10, 2, "pow"));
    }

    @Test
    void testNullOp() {
        assertEquals(0, calculator.calculate(10, 5, null));
    }

    @Test
    void testUnknownOp() {
        assertEquals(0, calculator.calculate(10, 5, "unknown"));
    }
}

