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
            String extractCustomDelimiter = userInput.extractCustomDelimiter();
            CustomDelimiter customDelimiter = new CustomDelimiter(extractCustomDelimiter);
            String combineDelimiter = combineDelimiter(delimiterResult, customDelimiter.getCustomDelimiter());
            delimiterResult = new DelimiterResult(combineDelimiter);
            input = userInput.extractNumbersPart();
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
    
    private String combineDelimiter(DelimiterResult delimiterResult, String customDelimiter) {
        return delimiterResult.getDelimiterResult().replace("]", customDelimiter + "]");
    }


}
