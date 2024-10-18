package calculator.common.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String getUserInput() {
        System.out.println(MESSAGE);
        String userInput = Console.readLine();
        if (userInput.isBlank()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (userInput.startsWith("//")) {
            stringBuilder.append(userInput);
            stringBuilder.append("\n");
            String nextLine = Console.readLine();
            stringBuilder.append(nextLine);
            return stringBuilder.toString();
        } else {
            return userInput;
        }
    }
}
