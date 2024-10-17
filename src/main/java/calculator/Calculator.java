package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final ConsoleInputHandler consoleInputHandler;
    private final ConsoleOutputHandler consoleOutputHandler;
    private final DelimiterExtractor delimiterExtractor;

    public Calculator(ConsoleInputHandler consoleInputHandler, ConsoleOutputHandler consoleOutputHandler,
                      DelimiterExtractor delimiterExtractor) {
        this.consoleInputHandler = consoleInputHandler;
        this.consoleOutputHandler = consoleOutputHandler;
        this.delimiterExtractor = delimiterExtractor;
    }

    public void run() {
        // 0. 입력한다.
        String input = consoleInputHandler.input();

        // 1.커스텀 구분자를 추출한다.
        Delimiters delimiters = delimiterExtractor.extractCustomDelimiter(input);
        StringBuilder areaExcludingDelimiterRegex = delimiters.getAreaExcludingDelimiterRegex();

        //2. 구분자를 기준으로 숫자를 추출한다.
        List<Integer> numbers = extractNumberWithDelimiter(input, areaExcludingDelimiterRegex);

        // 3. 구한 숫자들을 더한다.
        int sum = addNumbers(numbers);

        consoleOutputHandler.printResult(sum);
    }

    private int addNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = addSafe(sum, number);
        }
        return sum;
    }

    private List<Integer> extractNumberWithDelimiter(String input, StringBuilder delimiterAreaRegex) {
        String[] splitedByRegex = input.split(delimiterAreaRegex.toString());
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(splitedByRegex)
                    .filter(str -> str.length() > 0)
                    .map(Integer::parseInt)
                    .map(this::getPositiveNumber)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
        }
        return numbers;
    }

    private int getPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }

        return number;
    }

    private int addSafe(int number1, int number2) {
        if (number1 > 0 && number2 > Integer.MAX_VALUE - number1) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        if (number2 > 0 && number1 > Integer.MAX_VALUE - number2) {
            throw new IllegalStateException("오버플로우가 발생했습니다.");
        }

        return number1 + number2;
    }

}
