package calculator.Model;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static void validInputText(char endChar) {
        if (!('0' < endChar && endChar <= '9')) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다. 허용되지 않는 문자가 포함되어 있습니다.");
        }
    }

    public static String consoleInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String rawText = Console.readLine();

        if (rawText.length() == 0) {
            return "0";
        }
        validInputText(rawText.charAt(rawText.length()-1));

        return rawText;
    }
}
