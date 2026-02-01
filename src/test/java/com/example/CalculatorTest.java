package main.java.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculate_Add() {
        // Act
        int result = calculator.calculate(10, 5, "add");
        
        // Assert
        assertEquals(15, result);
    }

    @Test
    void testCalculate_AddAgainOperation() {
        // Act
        int result = calculator.calculate(10, 5, "add-again");
        
        // Assert
        assertEquals(15, result);
    }

    @Test
    void testCalculate_Subtract() {
        // Act
        int result = calculator.calculate(10, 5, "sub");
        
        // Assert
        assertEquals(5, result);
    }

    @Test
    void testCalculate_SubtractAgainOperation() {
        // Act
        int result = calculator.calculate(10, 5, "sub-again");
        
        // Assert
        assertEquals(5, result);
    }

    @Test
    void testCalculate_Multiply() {
        // Act
        int result = calculator.calculate(10, 5, "mul");
        
        // Assert
        assertEquals(50, result);
    }

    @Test
    void testCalculate_Divide() {
        // Act
        int result = calculator.calculate(10, 5, "div");
        
        // Assert
        assertEquals(2, result);
    }

    @Test
    void testCalculate_DivideByZero() {
        // Act
        int result = calculator.calculate(10, 0, "div");
        
        // Assert
        assertEquals(0, result);
    }

    @Test
    void testCalculate_Modulo() {
        // Act
        int result = calculator.calculate(10, 3, "mod");
        
        // Assert
        assertEquals(1, result);
    }

    @Test
    void testCalculate_Power() {
        // Act
        int result = calculator.calculate(2, 3, "pow");
        
        // Assert
        assertEquals(8, result);
    }

    @Test
    void testCalculate_PowerOfZero() {
        // Act
        int result = calculator.calculate(5, 0, "pow");
        
        // Assert
        assertEquals(1, result); // Any number to the power of 0 is 1
    }

    @Test
    void testCalculate_PowerOfOne() {
        // Act
        int result = calculator.calculate(5, 1, "pow");
        
        // Assert
        assertEquals(5, result);
    }

    @Test
    void testCalculate_InvalidOperation() {
        // Act
        int result = calculator.calculate(10, 5, "invalid");
        
        // Assert
        assertEquals(0, result);
    }

    @Test
    void testCalculate_InvalidOperations() {
        // Test multiple invalid operations
        assertEquals(0, calculator.calculate(10, 5, "unknown"));
        assertEquals(0, calculator.calculate(10, 5, "invalid"));
        assertEquals(0, calculator.calculate(10, 5, ""));
        assertEquals(0, calculator.calculate(10, 5, "ADD"));
        assertEquals(0, calculator.calculate(10, 5, "SUB"));
    }

    @Test
    void testAddNumbers() {
        // Act
        int result = calculator.addNumbers(10, 5);
        
        // Assert
        assertEquals(15, result);
    }

    @Test
    void testAddNumbers_NegativeNumbers() {
        // Act
        int result = calculator.addNumbers(-10, -5);
        
        // Assert
        assertEquals(-15, result);
    }

    @Test
    void testAddNumbers_MixedNumbers() {
        // Act
        int result = calculator.addNumbers(-10, 15);
        
        // Assert
        assertEquals(5, result);
    }

    @Test
    void testSumValues() {
        // Act
        int result = calculator.sumValues(10, 5);
        
        // Assert
        assertEquals(15, result);
    }

    @Test
    void testSumValues_NegativeNumbers() {
        // Act
        int result = calculator.sumValues(-10, -5);
        
        // Assert
        assertEquals(-15, result);
    }

    @Test
    void testSumValues_Zero() {
        // Act
        int result = calculator.sumValues(10, 0);
        
        // Assert
        assertEquals(10, result);
    }

    @Test
    void testAddAgain() {
        // Act
        int result = calculator.addAgain(10, 5);
        
        // Assert
        assertEquals(15, result);
    }

    @Test
    void testAddAgain_LargeNumbers() {
        // Act
        int result = calculator.addAgain(1000, 2000);
        
        // Assert
        assertEquals(3000, result);
    }

    // Test edge cases for power operation
    @Test
    void testCalculate_PowerLargeExponent() {
        // Act
        int result = calculator.calculate(2, 10, "pow");
        
        // Assert
        assertEquals(1024, result);
    }

    @Test
    void testCalculate_PowerNegativeBase() {
        // Act
        int result = calculator.calculate(-2, 3, "pow");
        
        // Assert
        assertEquals(-8, result);
    }
    
    @Test
    void testCalculate_NegativeNumbers() {
        // Test negative number operations
        assertEquals(-15, calculator.calculate(-10, -5, "add")); // -10 + (-5) = -15
        assertEquals(-15, calculator.calculate(-10, 5, "sub"));  // -10 - 5 = -15
        assertEquals(50, calculator.calculate(-10, -5, "mul"));  // -10 * -5 = 50
        assertEquals(-2, calculator.calculate(-10, 5, "div"));   // -10 / 5 = -2
    }
    
    @Test
    void testCalculate_ZeroOperations() {
        // Test operations with zero  
        assertEquals(5, calculator.calculate(0, 5, "add"));      // 0 + 5 = 5
        assertEquals(-5, calculator.calculate(0, 5, "sub"));     // 0 - 5 = -5
        assertEquals(0, calculator.calculate(0, 5, "mul"));      // 0 * 5 = 0
        assertEquals(0, calculator.calculate(0, 5, "div"));      // 0 / 5 = 0
        assertEquals(1, calculator.calculate(0, 0, "pow"));      // 0^0 = 1 in this implementation
    }
    
    @Test
    void testDuplicateMethodsCoverage() {
        // Ensure all duplicate methods are called for complete coverage
        assertEquals(100, calculator.addNumbers(50, 50));
        assertEquals(100, calculator.sumValues(40, 60));
        assertEquals(100, calculator.addAgain(25, 75));
        
        // Test with negative numbers
        assertEquals(-10, calculator.addNumbers(-5, -5));
        assertEquals(-20, calculator.sumValues(-10, -10));
        assertEquals(-30, calculator.addAgain(-15, -15));
    }
}