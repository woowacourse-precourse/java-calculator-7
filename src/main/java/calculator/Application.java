package calculator;

import calculator.common.exception.ExceptionFactory;
import calculator.delimiter.factory.DefaultDelimiterFactory;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.delimiter.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.delimiter.pattern_matcher.DefaultCustomDelimiterPatternMatcher;
import calculator.delimiter.service.CustomDelimiterService;
import calculator.delimiter.service.DelimiterService;
import calculator.delimiter.service.NumberDelimiterService;
import calculator.delimiter.validator.DefaultCustomDelimiterValidator;
import calculator.delimiter.validator.DelimiterValidator;
import calculator.util.integer.IntegerUtils;
import calculator.util.io.IOConsole;

import java.util.List;

import static calculator.common.exception.ExceptionType.NOT_DELIMITER;

public class Application {

    private static final CustomDelimiterPatternMatcher customDelimiterPatternMatcher = new DefaultCustomDelimiterPatternMatcher();
    private static final DelimiterValidator delimiterValidator = new DefaultCustomDelimiterValidator();
    private static final DelimiterFactory delimiterFactory = new DefaultDelimiterFactory(delimiterValidator);
    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService(
            delimiterFactory, customDelimiterPatternMatcher
    );
    private static final DelimiterService delimiterService = new NumberDelimiterService(delimiterFactory, customDelimiterService);

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = IOConsole.readLine();

        List<String> numberStrings = delimiterService.splitByDelimiters(input);

        try {
            List<Integer> numbers = IntegerUtils.parseIntegers(numberStrings);
            int sum = IntegerUtils.sum(numbers);
            IOConsole.print("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw ExceptionFactory.createException(NOT_DELIMITER);
        }
    }
}
