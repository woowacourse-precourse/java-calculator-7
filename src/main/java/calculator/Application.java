package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String userInput = Console.readLine();

        String[] parsedNumbers = parseInput(userInput);
        int sumResult = sumParsedNumbers(parsedNumbers);

        System.out.println("결과 : " + sumResult);
    }

    public static String[] parseInput(String input) {
        String delimiters = ",|:";
        String numberSection = input;

        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            delimiters = customDelimiter + "|" + delimiters;
            numberSection = extractNumbersSection(input);
        }

        return splitNumbers(numberSection, delimiters);
    }

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    public static int findDelimiterEndIndex(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return delimiterEndIndex;
    }

    public static String extractCustomDelimiter(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);

        if (delimiterEndIndex == 2) {
            throw new IllegalArgumentException("구분자가 비어 있습니다. 구분자를 입력하세요.");
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 올바르지 않습니다.");
        }

        return escapeSpecialCharactersInDelimiter(customDelimiter);
    }

    public static String extractNumbersSection(String input) {
        int delimiterEndIndex = findDelimiterEndIndex(input);
        return input.substring(delimiterEndIndex + 2);
    }

    public static String[] splitNumbers(String input, String delimiter) {
        return input.split(delimiter);
    }

    public static int sumParsedNumbers(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                } else {
                    sum += parsedNumber;
                }
            }
        }
        return sum;
    }

    public static String escapeSpecialCharactersInDelimiter(String delimiter) {
        return delimiter.replaceAll("([\\\\.^$|?*+()\\[\\]{}])", "\\\\$1");
    }
}
