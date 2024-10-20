package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    private static final char FIRST_DEFAULT_DELIMITER = ':';
    private static final char SECOND_DEFAULT_DELIMITER = ',';

    private static Calculator calculator;
    private ArrayList<Character> delimiters = new ArrayList<>(Arrays.asList(FIRST_DEFAULT_DELIMITER, SECOND_DEFAULT_DELIMITER));
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

    public void addCustomDelimiter(char newDelimiter) {
        delimiters.add(newDelimiter);
    }

    public ArrayList<Character> getDelimiters() {
        return delimiters;
    }

    public void setOperands(ArrayList<Integer> operands) {
        this.operands = operands;
    }

    public void saveResult() {
        int sum = 0;
        for (Integer operand : operands) {
            sum += operand;
        }
        result = sum;
    }

    public int getResult() {
        return result;
    }
}
