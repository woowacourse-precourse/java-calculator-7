package calculator;

import static calculator.SumCalculator.getFinalResult;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public void runCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine();

        Integer finalResult = getFinalResult(userInput);
        System.out.println("결과 : " + finalResult);
    }

}
