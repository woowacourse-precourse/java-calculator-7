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
        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            String numbersSection = extractNumbersSection(input);

            String combinedDelimiters = customDelimiter + "|,|:";

            return splitNumbers(numbersSection, combinedDelimiters);
        } else {
            return splitNumbers(input, ",|:");
        }
    }

    public static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    public static String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return escapeSpecailCharactersInDelimiter(input.substring(2, delimiterEndIndex));
    }

    public static String extractNumbersSection(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
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

    public static String escapeSpecailCharactersInDelimiter(String delimiter) {
        return delimiter.replaceAll("([\\\\.^$|?*+()\\[\\]{}])", "\\\\$1");
    }
}
