package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class StringSeparator {

    private Calculator calculator;

    public void divideSeparator(String str) {
        String number = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number += str.charAt(i);
            } else {
                if (!number.isEmpty()) {
                    calculator.addNumber(Integer.parseInt(number));
                }
                if (calculator)
            }
        }
    }
}
