package calculator;

import calculator.delimiter.CustomDelimiterService;
import calculator.delimiter.DelimiterFactory;
import calculator.delimiter.Delimiters;
import calculator.util.console.IOConsole;
import calculator.util.integer.IntegerUtils;

import java.util.List;

public class Application {

    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService();

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = IOConsole.readLine();

        Delimiters delimiters = getDelimiters(input);

        List<String> numberTokens = delimiters.split(customDelimiterService.trimCustomDelimiter(input));

        try {
            List<Integer> numbers = IntegerUtils.parsePositiveIntegers(numberTokens);
            int sum = IntegerUtils.sum(numbers);
            IOConsole.print("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구분자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private static Delimiters getDelimiters(String input) {
        return customDelimiterService.extract(input)
                .map(DelimiterFactory::createDelimiters)
                .orElseGet(DelimiterFactory::createDelimiters);
    }
}
