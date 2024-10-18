package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String ADDITION_INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private final static String DEFAULT_DELIMITERS = ",:";

    public String getAdditionInput() {
        System.out.println(ADDITION_INPUT_PROMPT_MESSAGE);
        String additionInput = Console.readLine();
        return additionInput;
    }

    public boolean containsCustomDelimiter(String additionInput) {
        if(additionInput.length() >= 5 && additionInput.startsWith("//") && additionInput.substring(3, 5).equals("\\n")) return true;
        return false;
    }

    public String getCustomDelimiter(String additionInput) {
        return additionInput.substring(2, 3);
    }

    public String deleteCustomDelimiter(String additionInput) {
        return additionInput.substring(5);
    }

    public String getDefaultDelimiters() {
        return DEFAULT_DELIMITERS;
    }
}
