package calculator.service;

import calculator.model.Calculator;
import calculator.model.Delimiter;
import calculator.validator.OperandValidator;

import java.util.ArrayList;

public class StringSplit {

    private String inputString;
    Delimiter delimiter = new Delimiter();
    Calculator calculator = Calculator.getInstance();

    public StringSplit(String inputString) {
        this.inputString = inputString;
    }

    public void preprocessDelimiter() {
        findCustomDelimiter();
        takeOffCustomDelimiter();
    }

    private void findCustomDelimiter() {
        if (inputString.startsWith("//")) {
            char newDelimiter = inputString.charAt(2);
            delimiter.addCustomDelimiter(newDelimiter);
        }
    }

    private void takeOffCustomDelimiter() {
        if (inputString.startsWith("//")) {
            inputString = inputString.substring(5);
        }
    }

    public void splitAndSaveOperands() {
        String[] stringOperands = splitOperands();
        OperandValidator.validateStringOperand(stringOperands);
        ArrayList<Integer> intOperands = convertOperandsToInt(stringOperands);
        saveOperands(intOperands);
    }

    private String[] splitOperands() {
        String reg = "";
        for (Character delimiter : delimiter.getDelimiters()) {
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
}
