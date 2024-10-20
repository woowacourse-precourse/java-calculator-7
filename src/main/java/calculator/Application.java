package calculator;

import calculator.domain.calculation.Calculator;
import calculator.inputReader.ConsoleInputReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = CalculatorFactory.createCalculator();
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String readLine = consoleInputReader.readLine();
        int result = calculator.calculate(readLine);
        System.out.println("결과 : " + result);
    }
}
