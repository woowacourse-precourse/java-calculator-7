package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class StringSeparator {

    private Calculator calculator;

    public StringSeparator(Calculator calculator) {
        this.calculator = calculator;
    }

    public void divideSeparator(String str) {
        String number = "";
        String divide = "";
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (!divide.isEmpty()) {
                    if (divide.charAt(0) != '/' || divide.charAt(1) != '/' || divide.charAt(divide.length() - 1) != 'n'|| divide.charAt(divide.length() - 2) != '\\') {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    } else {
                        String separator = divide.substring(2, divide.length() - 2);
                        calculator.addSeparator(separator);
                        divide = "";
                    }
                }
                number += str.charAt(i);
            } else {
                if (calculator.getSeparators().contains(str.charAt(i))) {
                    if (!number.isEmpty()) {
                        calculator.addNumber(Integer.parseInt(number));
                    }
                } else {
                    divide += str.charAt(i);
                }
            }
        }
    }

}
