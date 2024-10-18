package calculator;

import calculator.io.InputOutputHandler;
import calculator.io.InputParser;
import calculator.io.InputValidator;
import calculator.numberExtractor.NumberExtractorImpl;
import calculator.separatorProvider.SeparatorProviderImpl;

/**
 * 문자열 덧셈이 필요한 여러 의존성들을 관리한다.
 */
public class ApplicationFactory {

    private InputOutputHandler inputOutputHandler;
    private StringCalculator stringCalculator;

    public ApplicationFactory() {
        createInputOutputHandler();
        createStringCalculator();
    }

    /**
     * IO 처리에 필요한 InputOutputHandler를 제공한다.
     *
     * @return InputOutputHandler
     */
    public InputOutputHandler getInputOutputHandler() {
        return inputOutputHandler;
    }

    /**
     * 문자열 덧셈에 필요한 StringCalculator를 제공한다.
     *
     * @return StringCalculator
     */
    public StringCalculator getStringCalculator() {
        return stringCalculator;
    }

    private void createInputOutputHandler() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        this.inputOutputHandler = new InputOutputHandler(inputValidator, inputParser);
    }

    private void createStringCalculator() {
        SeparatorProviderImpl customSeparatorExtractor = new SeparatorProviderImpl();
        NumberExtractorImpl numberExtractor = new NumberExtractorImpl();
        Calculator calculator = new Calculator();
        this.stringCalculator = new StringCalculator(customSeparatorExtractor, numberExtractor, calculator);
    }
}
