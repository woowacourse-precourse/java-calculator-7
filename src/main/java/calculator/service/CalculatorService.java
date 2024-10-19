package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class CalculatorService {

    Calculator calculator;
    boolean isValid;

    public void setIsValid(boolean valid) {
        isValid = valid;
    }

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
        isValid = true;
    }

    public void getInputValues(String input) {
        calculator.setRawValue(input);
    }

    public void validateInput() {
        String rawValue = calculator.getRawValue();
        System.out.println("시작값 : " + rawValue);
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

        System.out.println("분리된 애들: " + newSeparator +" " +value);

        makeNewSeparator(newSeparator);
        int[] processedValue = checkValue(value);
        if (!isValid) {
            throw new IllegalArgumentException();
        }
        calculator.setProcessedValue(processedValue);
    }

    private int[] checkValue(String value) {
        String regex = "[" + String.join("", calculator.getSeparators()) + "]";
        String[] targets = value.split(regex);
        int[] processedValue = new int[targets.length];
        try {
            for (int i = 0; i < targets.length; i++) {
                int number = Integer.parseInt(targets[i]);  // 문자열을 정수로 변환
                if (number <= 0) {
                    isValid = false;
                    break;
                }
                processedValue[i] = number;
            }
        } catch (Exception e) {
            isValid = false;
        }
        return processedValue;
    }

    private boolean checkNewSeparator(String newSeparator) {
        for (int i = 0; i < 2; i++) {
            if (newSeparator.charAt(i) != '/') {
                System.out.println("앞에 // 가 없어");
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

    public List<Integer> extractNumbersToList() {
        return List.of();
    }

    public int sumOfList() {
        return 0;
    }

    public String printResult() {
        return null;
    }
}

