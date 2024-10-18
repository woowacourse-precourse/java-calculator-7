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
        } else if (isStringWithCustomSeparator(userInput)) {
            String formattedInput = formatBackslash(userInput);
            String refinedInput = removeSeparatorInitializer(formattedInput);
            int result = sum(refinedInput, getCustomSeparator(userInput));
            printResult(result);
        } else {
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
        String str = input.replace("\\", "\\\\");
        return str.replace("\n", "\\n");
    }

    private String getCustomSeparator(String input) {
        int idx = input.indexOf("\\n");
        return input.substring(2, idx);
    }

    private String removeSeparatorInitializer(String input) {
        return input.substring(4 + getCustomSeparator(input).length());
    }

    private boolean isStringWithCustomSeparator(String input) {
        String str = formatBackslash(input);

        int idx = str.indexOf("\\n");
        if (idx == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
        str = removeSeparatorInitializer(str);
        str = removeNumber(str);
        str = removeSeparator(str, getCustomSeparator(input));
        return input.indexOf("//") == 0 && str.isEmpty();
    }

    private String formatSeparator(String separator) {
        return "[" + separator.replace("\\", "\\\\") + "]";
    }

    private int sum(String input, String separator) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] nums = input.split(formatSeparator(separator));
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
