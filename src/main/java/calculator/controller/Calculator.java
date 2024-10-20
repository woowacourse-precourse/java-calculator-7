package calculator.controller;

import calculator.model.Separator;


import static calculator.model.Separator.*;

public class Calculator {
    private String input;


    public Calculator(String input) {
        this.input = input;
        activeSeparator = DEFAULT_SEPARATOR;


    }
    public void parseInput() {
        String token = Separator.checkCustomSeparator(input);
        System.out.println("결말 ;토큰 상태: " + token +"활성 구분자:" +activeSeparator);
    }
}
