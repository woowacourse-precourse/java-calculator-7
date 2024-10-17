package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final static String INPUT_STRING_TO_ADD = "덧셈할 문자열을 입력해주세요.";
    private final static String DEFAULT_REGEX = "[,:]";

    public List<String> getInputString() {
        System.out.println(INPUT_STRING_TO_ADD);
        String inputString = Console.readLine();
        List<String> numbersList = splitByDefaultRegex(inputString);
        return numbersList;
    }

    public List<String> splitByDefaultRegex(String inputString) {
        return List.of(inputString.split(DEFAULT_REGEX));
    }
}
