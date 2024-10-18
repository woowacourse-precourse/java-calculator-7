package calculator.view;

import calculator.model.CalculationString;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";

    public CalculationString readInput() {
        System.out.println(INPUT_PROMPT);
        String inputString = Console.readLine();
        return new CalculationString(inputString);
    }
}
