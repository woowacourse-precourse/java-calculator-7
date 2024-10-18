package calculator.service;

import calculator.constant.Constant;
import calculator.model.Calculator;
import calculator.validator.InputValidator;

import java.util.ArrayList;

public class StringCalculate {

    private static final String REGEX_START = "\\";
    private static final String REGEX_OR = "|";

    private String inputString;
    Calculator calculator = Calculator.getInstance();

    public StringCalculate(String inputString) {
        this.inputString = inputString;
    }

    public void preprocessDelimiter() {
        findCustomDelimiter();
        takeOffCustomDelimiter();
    }

    private void findCustomDelimiter() {
        if (inputString.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            char newDelimiter = inputString.charAt(2);
            calculator.addCustomDelimiter(newDelimiter);
        }
    }

    private void takeOffCustomDelimiter() {
        if (inputString.startsWith(Constant.CUSTOM_DELIMITER_PREFIX)) {
            inputString = inputString.substring(5);
        }
    }

    public void splitAndSaveOperands() {
        String[] stringOperands = splitOperands();
        InputValidator.validateStringOperand(stringOperands);
        ArrayList<Integer> intOperands = convertOperandsToInt(stringOperands);
        saveOperands(intOperands);
    }

    private String[] splitOperands() {
        String reg = "";
        for (Character delimiter : calculator.getDelimiters()) {
            reg += (REGEX_START + delimiter + REGEX_OR);
        }
        if (!reg.isEmpty()) {
            reg = reg.substring(0, reg.length() - 1);
        }
        return inputString.split(reg, -1);
    }

    private ArrayList<Integer> convertOperandsToInt(String[] stringOperands) {
        ArrayList<Integer> intOperands = new ArrayList<>();
        for (String stringOperand : stringOperands) {
            if (stringOperand.equals(Constant.BLANK)) {
                intOperands.add(Constant.ZERO);
            } else {
                intOperands.add(Integer.valueOf(stringOperand));
            }
        }
        return intOperands;
    }

    private void saveOperands(ArrayList<Integer> intOperands) {
        calculator.setOperands(intOperands);
    }

    public void calculate() {
        calculator.saveResult();
    }

    public int fetchResult() {
        return calculator.getResult();
    }
}
