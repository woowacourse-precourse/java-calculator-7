package calculator.service;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorService {

    Calculator calculator;
    ExceptionHandler exceptionHandler;
    boolean isValid;

    public void setIsValid(boolean valid) {
        isValid = valid;
    }

    public CalculatorService(Calculator calculator, ExceptionHandler exceptionHandler) {
        this.calculator = calculator;
        this.exceptionHandler = exceptionHandler;
        isValid = true;
    }

    public void getInputValues(String input) {
        calculator.setRawValue(input);
    }

    public void validateInput() {
        String rawValue = calculator.getRawValue();
        String newSeparator = null;
        String value;

        if (rawValue.startsWith("//")) {
            String[] results = rawValue.split("\n", 2);
            newSeparator = results[0];
            value = results.length > 1 ? results[1] : "";
            isValid = checkNewSeparator(newSeparator);
            makeNewSeparator(newSeparator);
        } else {
            value = rawValue;
        }

        calculator.setRawValue(value);
        List<Number> processedValue = extractNumbersToList();

        if (!isValid) {
            exceptionHandler.handleException(new IllegalArgumentException());
        }
        calculator.setProcessedValue(processedValue);
    }

//
//    public void validateInput() {
//        String rawValue = calculator.getRawValue();
//        String newSeparator = null;
//        String value = "";
//        String[] results = rawValue.split("\\\\n", 2);
//
//        if (results.length > 1) {
//            newSeparator = results[0];
//            value = results[1];
//            isValid = checkNewSeparator(newSeparator);
//        } else {
//            value = results[0];
//        }
//
//        makeNewSeparator(newSeparator);
//        calculator.setRawValue(value);
//        List<Number> processedValue = extractNumbersToList();
//        if (!isValid) {
//            exceptionHandler.handleException(new IllegalArgumentException());
//        }
//        calculator.setProcessedValue(processedValue);
//    }

    public List<Number> extractNumbersToList() {
        List<String> resultList = new ArrayList<>(List.of(calculator.getRawValue()));
        try {
            for (String separator : calculator.getSeparators()) {
                List<String> tempList = new ArrayList<>();
                for (String item : resultList) {
                    String regex = Pattern.quote(separator);
                    tempList.addAll(Arrays.asList(item.split(regex)));
                }
                resultList = tempList;
            }
        } catch (Exception e) {
            isValid = false;
        }

        List<Number> processedValue = new ArrayList<>();
        for (String item : resultList) {
            if (item.trim().isEmpty()) continue;
            if (!item.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid input: " + item);
            }
            processedValue.add(new BigInteger(item));
        }
        return processedValue;
    }


    private boolean checkNewSeparator(String newSeparator) {
        return newSeparator.startsWith("//");
    }

    public void makeNewSeparator(String newSeparator) {
        if (newSeparator == null) return;
        String result = newSeparator.substring(2);
        List<String> newSeparators = calculator.getSeparators();
        newSeparators.add(result);
        calculator.setSeparators(newSeparators);
    }

    public Number sumOfList() {
        List<Number> values = calculator.getProcessedValue();
        BigInteger sum = BigInteger.ZERO;
        for (Number value : values) {
            sum = sum.add((BigInteger) value);
        }
        calculator.setSumValue(sum);
        return sum;
    }

    public void printResult() {
        BigInteger sum = (BigInteger) calculator.getSumValue();
        System.out.println("결과 : " + sum);
    }
}