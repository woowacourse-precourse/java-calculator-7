package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculatorView implements CalculatorView{

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE_FORMAT = "결과 : %s\n";

    @Override
    public String displayInput() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    @Override
    public void displayOutput(String output) {
        System.out.printf(OUTPUT_MESSAGE_FORMAT, output);
    }
}
