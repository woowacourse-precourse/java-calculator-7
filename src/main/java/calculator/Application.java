package calculator;

import calculator.common.exception.ExceptionFactory;
import calculator.delimiter.domain.Delimiters;
import calculator.delimiter.factory.DefaultDelimiterFactory;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.delimiter.pattern.CustomDelimiterPatternMatcher;
import calculator.delimiter.pattern.DefaultCustomDelimiterPatternMatcher;
import calculator.delimiter.service.CustomDelimiterService;
import calculator.delimiter.validator.CustomDelimiterValidator;
import calculator.delimiter.validator.DefaultCustomDelimiterValidator;
import calculator.util.integer.IntegerUtils;
import calculator.util.io.IOConsole;

import java.util.List;

import static calculator.common.exception.ExceptionType.NOT_DELIMITER;

public class Application {

    private static final CustomDelimiterPatternMatcher customDelimiterPatternMatcher = new DefaultCustomDelimiterPatternMatcher();
    private static final CustomDelimiterValidator customDelimiterValidator = new DefaultCustomDelimiterValidator();
    private static final DelimiterFactory delimiterFactory = new DefaultDelimiterFactory(customDelimiterValidator);
    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService(delimiterFactory, customDelimiterPatternMatcher);

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
            throw ExceptionFactory.createException(NOT_DELIMITER);
        }
    }

    private static Delimiters getDelimiters(String input) {
        return customDelimiterService.extract(input)
                .map(customDelimiterService::createDelimiters)
                .orElseGet(customDelimiterService::createDelimiters);
    }
}
