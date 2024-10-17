package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.Calculator();
    }

    static String defaultSeparator = ",:";

    public void Calculator() {
        printUserInputMessage();
        String userInput = getUserInput();

        if (isStringWithDefaultSeparator(userInput)) {
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

    public String removeNumber(String str) {
        return str.replaceAll("[0-9]", "");
    }

    public String removeSeparator(String str, String separator) {
        return str.replaceAll(formatSeparator(separator), "");
    }

    public Boolean isStringWithDefaultSeparator(String input) {
        String str = removeNumber(input);
        str = removeSeparator(str, defaultSeparator);
        return str.isEmpty();
    }

    public String getCustomSeparator(String input) {
        String[] arr = input.split("//|\\n");
        return arr[1];
    }

    public String removeSeparatorInitializer(String input) {
        return input.substring(3 + getCustomSeparator(input).length());
    }

    public Boolean isStringWithCustomSeparator(String input) {
        String str = removeSeparatorInitializer(input);
        str = removeNumber(str);
        str = removeSeparator(str, getCustomSeparator(input));
        return input.indexOf("//") == 0 && str.isEmpty();
    }

    private String formatSeparator(String separator) {
        return "[" + separator + "]";
    }

    public int sum(String str, String separator) {
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

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
