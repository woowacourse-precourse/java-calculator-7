package calculator.view.input;

import static calculator.view.validation.InputValidation.validateInputString;
import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    private static final String INPUT_MESSAGE = "아래 예시와 같이 문자를 입력해주세요.\n";
    private static final String INPUT_MESSAGE_EXAMPLE = "\"\" => 0, \"1,2\" => 3, \"1,2,3\" => 6, \"1,2:3\" => 6 (구분자: 쉼표(,) 또는 콜론(:))";
    private static final String INPUT_STRING = "문자열 입력: ";

    @Override
    public String readInputMessage() {
        System.out.println(INPUT_MESSAGE);
        System.out.println(INPUT_MESSAGE_EXAMPLE);
        System.out.println(INPUT_STRING);

        String inputData = Console.readLine();
        validateInputString(inputData);

        return inputData;
    }
}
