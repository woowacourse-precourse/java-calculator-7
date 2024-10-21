package calculator.presentation;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInput {

    private final InputParser inputParser;

    public CalculatorInput(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public CalculatorRequest read() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();

        return inputParser.parseToRequest(input);
    }
}
