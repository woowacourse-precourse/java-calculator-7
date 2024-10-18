package calculator;

import calculator.delimiter.custom.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.delimiter.custom.pattern_matcher.DefaultCustomDelimiterPatternMatcher;
import calculator.delimiter.custom.service.CustomDelimiterService;
import calculator.delimiter.custom.validator.DefaultCustomDelimiterValidator;
import calculator.delimiter.custom.validator.DelimiterValidator;
import calculator.delimiter.factory.DefaultDelimiterFactory;
import calculator.delimiter.factory.DelimiterFactory;
import calculator.delimiter.service.DelimiterService;
import calculator.delimiter.service.IntegerDelimiterService;
import calculator.util.integer.IntegerUtils;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class Application {

    private static final CustomDelimiterPatternMatcher customDelimiterPatternMatcher = new DefaultCustomDelimiterPatternMatcher();
    private static final DelimiterValidator delimiterValidator = new DefaultCustomDelimiterValidator();
    private static final DelimiterFactory delimiterFactory = new DefaultDelimiterFactory(delimiterValidator);
    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService(
            delimiterFactory, customDelimiterPatternMatcher
    );
    private static final DelimiterService delimiterService = new IntegerDelimiterService(delimiterFactory, customDelimiterService);

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {

        String input = inputView.readUserInput();

        List<String> numberStrings = delimiterService.splitByDelimiters(input);

        List<Integer> numbers = IntegerUtils.parseIntegers(numberStrings);
        int sum = IntegerUtils.sum(numbers);
        outputView.printSumResult(sum);
    }
}
