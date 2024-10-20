package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String userInput = Console.readLine();

        String[] parsedNumbers = parseInput(userInput);
        int sumResult = sumParsedNumbers(parsedNumbers);

        System.out.println("결과 : " + sumResult);
    }

    private static String[] parseInput(String input) {
        return splitNumbers(input, ",|;");
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static String extractCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 커스텀 구분자는 //과 \\n을 포함해야 합니다.");
        }
        return escapeSpecailCharactersInDelimiter(input.substring(2, delimiterEndIndex));
    }

    private static String extractNumbersSection(String input) {
        int delimiterEndIndex = input.indexOf("\\n");
        return input.substring(delimiterEndIndex + 2);
    }

    private static String[] splitNumbers(String input, String delimiter) {
        return input.split(delimiter);
    }
}
