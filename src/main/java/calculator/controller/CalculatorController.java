package calculator.controller;

import calculator.domain.Calculator;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        InputParser inputParser = new InputParser();
        int result = Calculator.sum(inputParser.parse(input));
        System.out.println("결과 : " + result);

        Console.close();
    }
}
