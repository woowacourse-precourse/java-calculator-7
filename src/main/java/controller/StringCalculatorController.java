package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.StringCalculator;

public class StringCalculatorController {
    private final StringCalculator calculator;

    public StringCalculatorController() {
        this.calculator = new StringCalculator();
    }

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        String input = Console.readLine();

        int result = calculator.add(input);
        System.out.println("결과 : " + result);
    }
}
