package calculator.view;

import calculator.dto.request.SumStringRequest;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public SumStringRequest getStringToAdd() {
        OutputView.writeln(INPUT_MESSAGE);
        String stringToAdd = Console.readLine();
        return new SumStringRequest(stringToAdd);
    }

}
