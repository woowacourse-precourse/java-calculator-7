package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        runCalculator();
    }

    public static void runCalculator() {
        String input = getInput();
        String[] strings = splitInput(input);
        int[] numbers = parseToIntArray(strings);
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    private static String[] splitInput(String input) {
        if (isCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String numbersPart = input.substring(input.indexOf("\\n") + 2);
            return numbersPart.split(customDelimiter);
        } else {
            return input.split("[,:]");
        }
    }

    public static boolean isCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\\n");
    }

    public static String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        String customDelimiter = input.substring(2, delimiterEndIndex);
        return customDelimiter;
    }

    public static int[] parseToIntArray(String[] strings) {
        int[] intArray = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            intArray[i] = parseToInt(strings[i]);
        }

        return intArray;
    }

    public static int parseToInt(String string) {
        if (string.isEmpty()) {
            return 0;
        } else {
            int number = Integer.parseInt(string);
            return number;
        }
    }
}
