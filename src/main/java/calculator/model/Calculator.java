package calculator.model;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> delimiters;

    public Calculator() {
        this.delimiters = new ArrayList<>();
        this.delimiters.add(",");
        this.delimiters.add(":");
    }

    public void patchDelimeter(String customDelimeter) {
        delimiters.add(customDelimeter);
    }

    public int calculate(String expression) {
        String regex = String.join("|", delimiters);
        String[] numbers = expression.split(regex);

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number); // 각 숫자를 더함
        }

        return sum;
    }
}
