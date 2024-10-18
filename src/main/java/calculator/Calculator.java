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
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 지정이 잘못된 형식입니다.");
        }
        String customDelimiter = this.inputString.substring(2, delimiterIndex);
        this.delimiter = "[" + delimiter.substring(1, delimiter.length() - 1) + customDelimiter + "]";
        inputString = inputString.substring(delimiterIndex + 2);
    }

    private void splitString() {

        if (this.inputString == null || this.inputString.trim().isEmpty()) {
            return;
        }

        if (this.inputString.startsWith("//")) {
            addDelimiter();
        }

        String[] numbersStr = inputString.split(delimiter);
        for (String s : numbersStr) {
            try {
                int number = Integer.parseInt(s.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수가 있습니다.");
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
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
