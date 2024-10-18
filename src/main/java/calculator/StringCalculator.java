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
            CustomDelimiter customDelimiter = new CustomDelimiter(findCustomDelimiter(userInput, customDelimiterEndIndex));
            String updateDelimiter = generateUpdateDelimiter(delimiterResult, customDelimiter.getCustomDelimiter());
            delimiterResult = new DelimiterResult(updateDelimiter);
            input = generateCombinedInput(userInput, customDelimiterEndIndex);
        }

        DelimitedNumbers delimitedNumbers = new DelimitedNumbers(input, delimiterResult);

        String[] separatedNumbers = generateSeparatedNumbers(delimitedNumbers, delimiterResult);
        Numbers numbers = new Numbers(separatedNumbers);

        int sum = calculateNumbers(numbers);

        System.out.println("결과 : " + sum);

    }

    private int calculateNumbers(Numbers numbers) {
        int sum = 0;
        for (String stringNumbers : numbers.getNumbers()) {
            Number number = new Number(stringNumbers);
            sum += Integer.parseInt(number.getNumber());
        }
        return sum;
    }

    private String[] generateSeparatedNumbers(DelimitedNumbers delimitedNumbers, DelimiterResult delimiterResult) {
        return delimitedNumbers.getStringNumbers().split(delimiterResult.getDelimiterResult());
    }

    private String generateCombinedInput(UserInput userInput, int customDelimiterEndIndex) {
        return userInput.getUserInput().substring(customDelimiterEndIndex + 2);
    }

    private String generateUpdateDelimiter(DelimiterResult delimiterResult, String customDelimiter) {
        return delimiterResult.getDelimiterResult().replace("]", customDelimiter + "]");
    }

    private String findCustomDelimiter(UserInput userInput, int customDelimiterEndIndex) {
        return userInput.getUserInput().substring(2, customDelimiterEndIndex);
    }

    private int findCustomDelimiterEndIndex(UserInput userInput) {
        return userInput.getUserInput().indexOf("\\n");
    }

}
