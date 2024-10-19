package calculator.app;

import calculator.calculator.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorApp {
    private Calculator stringCalculator;

    public StringCalculatorApp(Calculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    public void run() {
        String inputData = readInput();
    }

    // 1. 문자열 입력받기
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

}
