package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleIO {
    public void run(StringCalculator calculator) {
        String input = readInput();
        long result = calculator.calculate(input);
        printResult(result);
    }

    private String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    private void printResult(long result) {
        System.out.println("결과 : " + result);
    }
}
