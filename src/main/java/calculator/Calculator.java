package calculator;

public class Calculator {

    public static int parseInput(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String customDelimiter = DelimiterFinder.findDelimiter(input);
        int beginIndex = DelimiterFinder.findDelimiterEndIndex(input);
        String[] numbers = ParseSplitter.splitString(input, customDelimiter, beginIndex);
        return calculateAdd(numbers);
    }

    private static int calculateAdd(String[] numbers) {
        long result = 0;

        for (String numString : numbers) {
            int number = ParseSplitter.customParse(numString);
            // 오버플로우 방지
            if (result + number > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("INT 초과하는 합 : " + result + " + " + number);
            }
            result += number;
        }
        return (int) result;
    }
}
