package calculator.view.input;

import static calculator.view.validation.InputValidation.validateInputString;
import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";

    @Override
    public String readInputMessage() {
        System.out.println(INPUT_STRING);

        String inputData = Console.readLine();
        validateInputString(inputData);

        return inputData;
    }
}
