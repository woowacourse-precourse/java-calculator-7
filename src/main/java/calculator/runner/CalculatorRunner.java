package calculator.runner;

import calculator.core.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorRunner {

    private CalculatorRunner() {}

    public static void run() {
        turnOn();
        Calculator calculator = getCalculator(readValue());
        printResult(calculator.sum());
    }

    private static void turnOn() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private static String readValue() {
        String value = Console.readLine();
        Console.close();
        return value;
    }

    private static Calculator getCalculator(String value) {
        return Calculator.enterValue(value);
    }

    private static void printResult(long result) {
        System.out.println("결과 : " + result);
    }

}
