package main.java.com.example;

public class Calculator {

    private static final String OP_ADD = "add";
    private static final String OP_ADD_AGAIN = "add-again";
    private static final String OP_SUB = "sub";
    private static final String OP_SUB_AGAIN = "sub-again";
    private static final String OP_MUL = "mul";
    private static final String OP_DIV = "div";
    private static final String OP_MOD = "mod";
    private static final String OP_POW = "pow";

    public int calculate(int a, int b, String op) {
        if (op == null) {
            return 0;
        }

        switch (op) {
            case OP_ADD, OP_ADD_AGAIN:
                return a + b;
            case OP_SUB, OP_SUB_AGAIN:
                return a - b;
            case OP_MUL:
                return a * b;
            case OP_DIV:
                return (b == 0) ? 0 : a / b;
            case OP_MOD:
                return a % b;
            case OP_POW:
                return (int) Math.pow(a, b);
            default:
                return 0;
        }
    }
}