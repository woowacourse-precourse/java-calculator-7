package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static String CUSTOM_SEPARATOR_FRONT = "//";
    private static String CUSTOM_SEPARATOR_END = "\\n";
    private static List<String> DEFAULT_SEPARATORS = List.of(",", ":");

    public static void main(String[] args) {
        String input = Console.readLine();
        String customSeparator = getCustomSeparator(input);
        List<String> separators = getSeparators(customSeparator);
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

    private static List<String> getSeparators(String customSeparator) {
        List<String> separators = new ArrayList<>();

        if (customSeparator != null) {
            separators.addAll(DEFAULT_SEPARATORS);
            separators.add(customSeparator);
        }

        return separators;
    }
}
