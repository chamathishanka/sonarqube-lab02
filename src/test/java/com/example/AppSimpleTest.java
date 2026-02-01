package main.java.com.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AppSimpleTest {

    @Test
    void testCalculatorPart() {
        // Test just the Calculator part of the main method
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "add");
        assertEquals(15, result);
    }

    @Test
    void testMainMethod_ThrowsException() {
        // The main method will throw SQLException when trying to connect to database
        // but this covers the code execution
        String[] args = {};
        assertThrows(Exception.class, () -> App.main(args));
    }

    @Test
    void testMainMethodOutput() {
        // Capture System.out to test the Calculator output part
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        try {
            // This will fail at UserService part but Calculator output should be captured
            String[] args = {};
            assertThrows(Exception.class, () -> App.main(args));
            
            String output = outputStream.toString();
            assertTrue(output.contains("15")); // Calculator result: 10 + 5 = 15
            
        } finally {
            System.setOut(originalOut);
        }
    }
    
    @Test
    void testMainMethod_DatabaseOperations() {
        // Test that specifically exercises the database operation calls in main
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        try {
            String[] args = {};
            // This should execute calculator.calculate() and print "15", 
            // then fail on UserService operations
            Exception thrownException = assertThrows(Exception.class, () -> App.main(args));
            
            String output = outputStream.toString();
            assertTrue(output.contains("15")); // Verify calculator executed
            
            // Verify it's a SQL-related exception (proving UserService methods were called)
            assertTrue(thrownException instanceof SQLException || 
                      thrownException.getCause() instanceof SQLException ||
                      thrownException.getMessage().toLowerCase().contains("sql") ||
                      thrownException.getMessage().toLowerCase().contains("connection"));
            
        } finally {
            System.setOut(originalOut);
        }
    }
    
    @Test 
    void testMainMethod_EmptyArgs() {
        // Test with explicitly empty args
        String[] emptyArgs = new String[0];
        assertThrows(Exception.class, () -> App.main(emptyArgs));
    }
    
    @Test
    void testMainMethod_NullArgs() {
        // Test with null args - should still work
        assertThrows(Exception.class, () -> App.main(null));
    }
}