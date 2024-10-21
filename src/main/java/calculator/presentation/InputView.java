package calculator.presentation;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String calculatorInputMessage;
    private final String defaultDelimiter;
    private final String customDelimiterPrefix;
    private final String customDelimiterSuffix;

    public InputView(String calculatorInputMessage, String defaultDelimiter, String customDelimiterPrefix, String customDelimiterSuffix) {
        this.calculatorInputMessage = calculatorInputMessage;
        this.defaultDelimiter = defaultDelimiter;
        this.customDelimiterPrefix = customDelimiterPrefix;
        this.customDelimiterSuffix = customDelimiterSuffix;
    }

    public String readInput() {
        System.out.println(calculatorInputMessage);
        return Console.readLine();
    }

    public String[] parseInput(String input) {
        if (input == null || input.isEmpty()) {
            return new String[]{"0"};
        }

        if (input.startsWith(customDelimiterPrefix)) {
            return handleCustomDelimiter(input);
        }

        return input.split(defaultDelimiter);
    }

    private String[] handleCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf(customDelimiterSuffix);

        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자가 올바르게 입력되지 않았습니다. \\n을 포함해주세요.");
        }

        String delimiter = defaultDelimiter + "|" + input.substring(customDelimiterPrefix.length(), delimiterIndex);
        String numbers = input.substring(delimiterIndex + customDelimiterSuffix.length());

        return numbers.split(delimiter);
    }
}
