package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String inputString;
    private int sum = 0;
    private String delimiter = "[,:]";
    private List<Integer> numbers = new ArrayList<>();

    Calculator() {
        this.inputString = Input.input();
    }

    private void printResult() {
        System.out.println("결과 : " + this.sum);
    }

    private void addDelimiter() {
        int delimiterIndex = inputString.indexOf("\\n");
        String customDelimiter = this.inputString.substring(2, delimiterIndex);
        this.delimiter = "[" + delimiter.substring(1, delimiter.length() - 1) + customDelimiter + "]";
        inputString = inputString.substring(delimiterIndex + 2);
    }

    private void splitString() {
        if (this.inputString.startsWith("//")) {
            addDelimiter();
        }
        String[] numbersStr = inputString.split(delimiter);
        for (String s : numbersStr) {
            int number = Integer.parseInt(s.trim());
            numbers.add(number);
        }
    }

    private void addSum() {
        for (Integer number : numbers) {
            sum += number;
        }
    }

    public void run() {
        splitString();
        addSum();
        printResult();
    }
}
