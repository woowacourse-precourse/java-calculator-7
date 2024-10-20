package calculator.domain;

import java.util.ArrayList;

public class Calculator {

    int sum;

    ArrayList<String> separators = new ArrayList<>();

    public Calculator() {
        this.sum = 0;
        separators.add(",");
        separators.add(":");
    }

    public ArrayList<String> getSeparators() {
        return separators;
    }

    public int sumNumber(String input, ArrayList<String> separator) {

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)){
                sum += current - '0';
            }
        }
        return sum;
    }
}
