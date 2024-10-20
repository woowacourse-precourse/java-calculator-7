package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Calculator {

    private ArrayList<String> delimiters;

    public Calculator() {
        this.delimiters = new ArrayList<>();
        this.delimiters.add(":");
        this.delimiters.add(",");
    }

    public void patchDelimeter(String customDelimiter) {
        if (!customDelimiter.isEmpty()) {
            delimiters.add(customDelimiter);
        }
    }

    public int sum(String expression) {
        //delimiters를 거꾸로 돌면서 구분자로 정의된 문자를 : 으로 변경해야 한다.
        String changedExpression = replaceDelimitersToColon(expression);

        String[] numbers = changedExpression.split(":");

        int sum = 0;
        for (String number : numbers) {
            if (!isPositiveNumber(number)) {
                throw new IllegalArgumentException();
            }
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private String replaceDelimitersToColon(String expression) {
        List<String> subDelimiters = delimiters.subList(1, delimiters.size());
        Collections.reverse(subDelimiters);

        for(String delimiter : subDelimiters){
            expression = expression.replace(delimiter,":");
        }
        return expression;
    }

    private boolean isPositiveNumber(String number) {
        return number.matches("[1-9]\\d*");
    }
}
