package calculator.service;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;

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
        String value = "";
        String[] results = rawValue.split("\\\\n", 2);

        if (results.length > 1) {
            newSeparator = results[0];
            value = results[1];
            isValid = checkNewSeparator(newSeparator);
        } else {
            value = results[0];
        }

        makeNewSeparator(newSeparator);
        calculator.setRawValue(value);
        List<Number> processedValue = extractNumbersToList();
        if (!isValid) {
            exceptionHandler.handleException(new IllegalArgumentException());
        }
        calculator.setProcessedValue(processedValue);
    }

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
            if (!item.matches("\\d+(\\.\\d+)?")) {
                throw new IllegalArgumentException();
            }
            if (item.contains(".")) {
                processedValue.add(Double.parseDouble(item));
            } else {
                processedValue.add(Long.parseLong(item));
            }
        }
        return processedValue;
    }

    private boolean checkNewSeparator(String newSeparator) {
        for (int i = 0; i < 2; i++) {
            if (newSeparator.charAt(i) != '/') {
                return false;
            }
        }

        return true;
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
        double sum = 0;
        for (Number value : values) {
            sum += value.doubleValue();
        }
        calculator.setSumValue(sum);
        return sum;
    }

    public String printResult() {
        Number sum = calculator.getSumValue();

        String result;
        if (sum.doubleValue() == sum.longValue()) {
            result = "결과 : " + sum.longValue();
        } else {
            result = "결과 : " + sum.doubleValue();
        }

        System.out.println(result);
        return result;
    }
}