package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    static String defaultSeparator = ",:";

    private void printUserInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private String getUserInput() {
        return Console.readLine();
    }

    public String removeNumber(String str) {
        return str.replaceAll("[0-9]", "");
    }

    public String removeSeparator(String str, String separator) {
        String formattedSeparator = "[" + separator + "]";
        return str.replaceAll(formattedSeparator, "");
    }

    public Boolean isStringWithDefaultSeparator(String input, String separator) {
        String str = removeNumber(input);
        str = removeSeparator(str, defaultSeparator);
        return str == "";
    }

    public String getCustomSeparator(String input) {
        String[] arr = input.split("//|\\n");
        return arr[1];
    }
}
