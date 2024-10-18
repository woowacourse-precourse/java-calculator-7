package calculator.service;

import calculator.model.Calculator;
import calculator.validator.InputValidator;

import java.util.ArrayList;

public class StringCalculate {

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
        if (inputString.startsWith("//")) {
            char newDelimiter = inputString.charAt(2);
            calculator.addCustomDelimiter(newDelimiter);
        }
    }

    private void takeOffCustomDelimiter() {
        if (inputString.startsWith("//")) {
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
            reg += ("\\" + delimiter + "|");
        }
        if (!reg.isEmpty()) {
            reg = reg.substring(0, reg.length() - 1);
        }
        return inputString.split(reg);
    }

    private ArrayList<Integer> convertOperandsToInt(String[] stringOperands) {
        ArrayList<Integer> intOperands = new ArrayList<>();
        for (String stringOperand : stringOperands) {
            if (stringOperand.equals("")) {
                intOperands.add(0);
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
