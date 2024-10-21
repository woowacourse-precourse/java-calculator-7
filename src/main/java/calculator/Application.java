package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static String CUSTOM_SEPARATOR_FRONT = "//";
    private static String CUSTOM_SEPARATOR_END = "\\n";

    public static void main(String[] args) {
        String input = Console.readLine();
        String customSeparator = getCustomSeparator(input);
    }


    private static String getCustomSeparator(String input) {
        if (Character.isDigit(input.toCharArray()[0])) {
            return null;
        }

        if (!input.startsWith(CUSTOM_SEPARATOR_FRONT) || !input.contains(CUSTOM_SEPARATOR_END)) {
            throw new IllegalArgumentException();
        }

        return input.split(CUSTOM_SEPARATOR_END)[0];
    }
}
