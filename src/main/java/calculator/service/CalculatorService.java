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
            String[] results = rawValue.split("\\\\n", 2);
            if (results.length < 2) {
                throw new IllegalArgumentException();
            }
            newSeparator = results[0];
            value = results[1];
            makeNewSeparator(newSeparator);
        } else {
            value = rawValue;
        }

        calculator.setRawValue(value);
        List<Number> processedValue = extractNumbersToList();
        calculator.setProcessedValue(processedValue);
    }

    public List<Number> extractNumbersToList() {
        List<String> resultList = new ArrayList<>(List.of(calculator.getRawValue()));

        for (String separator : calculator.getSeparators()) {
            List<String> tempList = new ArrayList<>();
            for (String item : resultList) {
                String regex = Pattern.quote(separator);
                tempList.addAll(Arrays.asList(item.split(regex)));
            }
            resultList = tempList;
        }

        List<Number> processedValue = new ArrayList<>();
        for (String item : resultList) {
            if (item.trim().isEmpty()) continue;
            if (!item.matches("\\d+(\\.\\d+)?")) {
                throw new IllegalArgumentException();
            }
            processedValue.add(item.contains(".") ? Double.parseDouble(item) : new BigInteger(item));
        }
        return processedValue;
    }

    public void makeNewSeparator(String newSeparator) {
        if (newSeparator == null || !newSeparator.startsWith("//")) {
            throw new IllegalArgumentException();
        }
        String result = newSeparator.substring(2);
        calculator.getSeparators().add(result);
    }

    public Number sumOfList() {
        List<Number> values = calculator.getProcessedValue();
        double sum = 0;
        for (Number value : values) {
            sum += value.doubleValue();
        }
        calculator.setSumValue(sum);
        return sum;
    }

    public void printResult() {
        double sum = (double) calculator.getSumValue();

        if (sum == (long) sum) {
            System.out.println("결과 : " + (long) sum);
        } else {
            System.out.println("결과 : " + sum);
        }
    }
}