package calculator.service;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> processedValue = checkValue(value);
        if (!isValid) {
            exceptionHandler.handleException(new IllegalArgumentException());
        }
        calculator.setProcessedValue(processedValue);
    }

    private List<Integer> checkValue(String value) {
        List<String> resultList = new ArrayList<>(List.of(value)); // 초기 결과 리스트
        try {
            for (String separator : calculator.getSeparators()) {
                List<String> tempList = new ArrayList<>();
                for (String item : resultList) {
                    tempList.addAll(Arrays.asList(item.split("\\" + separator)));
                }
                resultList = tempList;
            }
        } catch (Exception e) {
            System.out.println("숫자가 아니어서 안됨");
            isValid = false;
        }
        List<Integer> processedValue = new ArrayList<>();
        for (String item : resultList) {
            System.out.print(item + " ");
            processedValue.add(Integer.parseInt(item));
        }
        System.out.println();
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
        System.out.println("새로운 값 :" + calculator.getSeparators());
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

