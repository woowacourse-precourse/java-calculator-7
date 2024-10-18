package calculator.controller;

import calculator.model.custom_delimiter.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.pattern_matcher.DefaultCustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.custom_delimiter.validator.DefaultCustomDelimiterValidator;
import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.factory.DefaultDelimiterFactory;
import calculator.model.delimiter.factory.DelimiterFactory;
import calculator.model.delimiter.service.DelimiterService;
import calculator.model.delimiter.service.IntegerDelimiterService;
import calculator.util.integer.IntegerUtils;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private static final CustomDelimiterPatternMatcher customDelimiterPatternMatcher = new DefaultCustomDelimiterPatternMatcher();
    private static final DelimiterValidator delimiterValidator = new DefaultCustomDelimiterValidator();
    private static final DelimiterFactory delimiterFactory = new DefaultDelimiterFactory(delimiterValidator);
    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService(
            delimiterFactory, customDelimiterPatternMatcher
    );
    private static final DelimiterService delimiterService = new IntegerDelimiterService(delimiterFactory, customDelimiterService);

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        String input = inputView.readUserInput();
        List<String> numberStrings = splitInputByDelimiters(input);
        List<Integer> numbers = parseNumberStringsToIntegers(numberStrings);
        int sum = calculateSum(numbers);
        outputView.printSumResult(sum);
    }

    private List<String> splitInputByDelimiters(String input) {
        return delimiterService.splitByDelimiters(input);
    }

    private List<Integer> parseNumberStringsToIntegers(List<String> numberStrings) {
        return IntegerUtils.parseIntegers(numberStrings);
    }

    private int calculateSum(List<Integer> numbers) {
        return IntegerUtils.sum(numbers);
    }
}
