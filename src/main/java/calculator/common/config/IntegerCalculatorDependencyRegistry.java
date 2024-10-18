package calculator.common.config;

import calculator.model.custom_delimiter.pattern_matcher.CustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.pattern_matcher.DefaultCustomDelimiterPatternMatcher;
import calculator.model.custom_delimiter.service.CustomDelimiterService;
import calculator.model.custom_delimiter.validator.DefaultCustomDelimiterValidator;
import calculator.model.custom_delimiter.validator.DelimiterValidator;
import calculator.model.delimiter.factory.DefaultDelimiterFactory;
import calculator.model.delimiter.factory.DelimiterFactory;
import calculator.model.delimiter.service.DelimiterService;
import calculator.model.delimiter.service.IntegerDelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class IntegerCalculatorDependencyRegistry implements NumberCalculatorDependencyRegistry {

    private static final CustomDelimiterPatternMatcher customDelimiterPatternMatcher = new DefaultCustomDelimiterPatternMatcher();
    private static final DelimiterValidator delimiterValidator = new DefaultCustomDelimiterValidator();
    private static final DelimiterFactory delimiterFactory = new DefaultDelimiterFactory(delimiterValidator);
    private static final CustomDelimiterService customDelimiterService = new CustomDelimiterService(delimiterFactory, customDelimiterPatternMatcher);
    private static final DelimiterService delimiterService = new IntegerDelimiterService(delimiterFactory, customDelimiterService);

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final IntegerCalculatorDependencyRegistry instance = new IntegerCalculatorDependencyRegistry();

    private IntegerCalculatorDependencyRegistry() {
    }

    public static IntegerCalculatorDependencyRegistry getInstance() {
        return instance;
    }

    public DelimiterService getDelimiterService() {
        return delimiterService;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }
}
