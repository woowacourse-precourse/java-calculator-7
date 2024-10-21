package calculator.view;

import calculator.dto.InputRequest;
import calculator.parser.InputParser;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static InputRequest getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        return InputParser.parseInput(input);
    }
}
