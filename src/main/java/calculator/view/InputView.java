package calculator.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final static String ADDITION_INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final static String DEFAULT_DELIMITERS = ",|:";

    private InputView() {
    }

    public static String getAdditionInput() {
        System.out.println(ADDITION_INPUT_PROMPT_MESSAGE);
        String additionInput = Console.readLine();
        return additionInput;
    }

    public static boolean containsCustomDelimiter(String additionInput) {
        if (additionInput.length() >= 5 &&
                additionInput.startsWith("//") &&
                additionInput.substring(3, 5).equals("\\n")) return true;
        return false;
    }

    public static String getCustomDelimiter(String additionInput) {
        return additionInput.substring(2, 3);
    }

    public static String deleteCustomDelimiter(String additionInput) {
        return additionInput.substring(5);
    }

    public static String getDefaultDelimiters() {
        return DEFAULT_DELIMITERS;
    }

    public static List<Integer> getOperands(List<String> separatedInput) {
        List<Integer> operands = new ArrayList<>();
        for (String token : separatedInput) {
            if (token.length() == 0) {
                continue;
            }
            operands.add(Integer.parseInt(token));
        }
        return operands;
    }

    public static List<String> separateStringToList(String s, String delimiters) {
        List<String> tokens = List.of(s.split(delimiters));
        return tokens;
    }
}