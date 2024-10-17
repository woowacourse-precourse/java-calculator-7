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
        return str.replaceAll(formatSeparator(separator), "");
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

    public String removeSeparatorInitializer(String input) {
        return input.substring(3 + getCustomSeparator(input).length());
    }

    public Boolean isStringWithCustomSeparator(String input, String separator) {
        String str = removeSeparatorInitializer(input);
        str = removeNumber(str);
        str = removeSeparator(str, getCustomSeparator(input));
        return input.indexOf("//") == 0 && str == "";
    }

    private String formatSeparator(String separator) {
        return "[" + separator + "]";
    }

    public int sum(String formattedStr, String separator) {
        if (formattedStr == "") {
            return 0;
        }

        String[] nums = formattedStr.split(formatSeparator(separator));
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
