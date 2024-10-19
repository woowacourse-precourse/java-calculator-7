package calculator.domain;

import java.util.ArrayList;

public class Calculator {

    int sum;

    public Calculator() {
        this.sum = 0;
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
