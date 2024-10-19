package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleIO {
    public void run(StringAdditionCalculator calculator) {
        try {
            String input = readInput();
            long result = calculator.calculate(input);
            printResult(result);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
        }
    }

    private String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    private void printResult(long result) {
        System.out.println("결과 : " + result);
    }

    private void printError(String errorMessage) {
        System.out.println("오류: " + errorMessage);
    }
}
