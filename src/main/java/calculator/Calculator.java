package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final String inputString;
    private int sum = 0;
    private String delimiter = "[,:]";
    private List<Integer> numbers = new ArrayList<>();

    private Calculator() {
        this.inputString = Input.input();
    }

    private void printResult() {
        System.out.println("결과 : " + this.sum);
    }

    private void splitString() {
        String[] numbersStr = inputString.split(delimiter);
        for (int i = 0; i < numbersStr.length; i++) {
            int number = Integer.parseInt(numbersStr[i].trim());
            numbers.add(number);
        }
    }
}
