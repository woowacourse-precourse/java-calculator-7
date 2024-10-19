package calculator.app;

import calculator.calculator.Calculator;
import calculator.calculator.StringCalculator;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorApp {
    private Calculator stringCalculator;

    public void run() {
        String inputData = readInput();
        // 2. 계산기 사용하여 정답 계산
        stringCalculator = new StringCalculator(inputData);
        int result = stringCalculator.sum();

    }

    // 1. 문자열 입력받기
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

}
