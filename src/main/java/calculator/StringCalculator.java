package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        UserInput userInput = new UserInput(input);
        String defaultDelimiter = "[,:]";
        DefaultDelimiter defaultDelimiters = new DefaultDelimiter(defaultDelimiter);
        DelimiterResult delimiterResult = new DelimiterResult(defaultDelimiters.getDefaultDelimiter());

        if (userInput.isCustom()) {
            int customDelimiterEndIndex = findCustomDelimiterEndIndex(userInput);
            String customDelimiter = findCustomDelimiter(userInput, customDelimiterEndIndex);
            String updateDelimiter = generateUpdateDelimiter(delimiterResult, customDelimiter);
            delimiterResult = new DelimiterResult(updateDelimiter);
            input = generateCombinedInput(userInput, customDelimiterEndIndex);
        }

        DelimitedNumbers delimitedNumbers = new DelimitedNumbers(input, delimiterResult);

        String[] separatedNumbers = delimitedNumbers.getStringNumbers().split(delimiterResult.getDelimiterResult());
        Numbers numbers = new Numbers(separatedNumbers);

        int sum = 0;
        for (String stringNumbers : numbers.getNumbers()) {
            Number number = new Number(stringNumbers);
            sum += Integer.parseInt(number.getNumber());
        }

        System.out.println("결과 : " + sum);

    }

    private String generateCombinedInput(UserInput userInput, int customDelimiterEndIndex) {
        return userInput.getUserInput().substring(customDelimiterEndIndex + 2);
    }

    private String generateUpdateDelimiter(DelimiterResult delimiterResult, String customDelimiter) {
        return delimiterResult.getDelimiterResult().replace("]", customDelimiter + "]");
    }

    private String findCustomDelimiter(UserInput userInput, int customDelimiterEndIndex) {
        String customDelimiter = userInput.getUserInput().substring(2, customDelimiterEndIndex);
        return customDelimiter;
    }

    private int findCustomDelimiterEndIndex(UserInput userInput) {
        int customDelimiterEndIndex = userInput.getUserInput().indexOf("\\n");
        return customDelimiterEndIndex;
    }

}
