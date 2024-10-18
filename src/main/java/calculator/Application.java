package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.Calculator();
    }

    public void Calculator() {
        String defaultSeparator = ",:";

        printUserInputMessage();
        String userInput = getUserInput();

        if (isStringWithDefaultSeparator(userInput, defaultSeparator)) {
            int result = sum(userInput, defaultSeparator);
            printResult(result);
        }
        else if(isStringWithCustomSeparator(userInput)) {
            String str = removeSeparatorInitializer(userInput);
            int result = sum(str, getCustomSeparator(userInput));
            printResult(result);
        }
        else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void printUserInputMessage() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private String removeNumber(String str) {
        return str.replaceAll("[0-9]", "");
    }

    private String removeSeparator(String str, String separator) {
        return str.replaceAll(formatSeparator(separator), "");
    }

    private boolean isStringWithDefaultSeparator(String input, String separator) {
        String str = removeNumber(input);
        str = removeSeparator(str, separator);
        return str.isEmpty();
    }

    private String formatBackslash(String input) {
        return input.replace("\\", "\\\\");
    }

    private String getCustomSeparator(String input) {
        String[] arr = input.split("//|\\n");
        return arr[1];
    }

    private String removeSeparatorInitializer(String input) {
        return input.substring(3 + getCustomSeparator(input).length());
    }

    private boolean isStringWithCustomSeparator(String input) {
        String str = removeSeparatorInitializer(input);
        str = removeNumber(str);
        str = removeSeparator(str, getCustomSeparator(input));
        return input.indexOf("//") == 0 && str.isEmpty();
    }

    private String formatSeparator(String separator) {
        return "[" + separator + "]";
    }

    private int sum(String str, String separator) {
        if (str.isEmpty()) {
            return 0;
        }

        String[] nums = str.split(formatSeparator(separator));
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }
        return result;
    }

    private void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
