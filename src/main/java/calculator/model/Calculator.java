package calculator.model;

import java.util.ArrayList;

public class Calculator {

    private static Calculator calculator;
    private ArrayList<Integer> operands;
    private int result;

    private Calculator() {

    }

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }
}
