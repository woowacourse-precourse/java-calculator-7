package calculator;

import camp.nextstep.edu.missionutils.Console;


public class CalculatorDisplayImpl implements ICalculatorDisplay {

    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    private static final String outputMessage = "결과 : %d";

    @Override
    public String getPromptInput() {
        System.out.println(inputMessage);

        String input = Console.readLine();
        Console.close();

        return input;
    }

    @Override
    public void printResult(long result) {
        System.out.printf(outputMessage, result);
    }
}
