package calculator.controller;

import calculator.handler.InputHandler;
import calculator.model.DelimiterTokenizer;
import calculator.model.InputString;
import calculator.view.OutputView;

/**
 * controller
 */
public class CalculatorController {

    private final DelimiterTokenizer delimiterTokenizer;
    private final InputHandler inputHandler;
    private final OutputView outputView;

    public CalculatorController(DelimiterTokenizer delimiterTokenizer, InputHandler inputHandler,
                                OutputView outputView) {
        this.delimiterTokenizer = delimiterTokenizer;
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    /**
     * 문자열 계산기 실행
     */
    public void run() {

        String input = inputHandler.getValidatedInput();

        InputString inputString = new InputString(input);
        String customDelimiter = inputString.getCustomDelimiterFromInput();
        String delimiters = delimiterTokenizer.combineDelimiters(customDelimiter);

        String validInputString = inputString.validateInputString(delimiters);

        long[] numberList = delimiterTokenizer.tokenizeString(validInputString);

        long resultSum = sum(numberList);

        outputView.getOutputResult(resultSum);
    }


    /**
     * 덧셈 계산
     */
    private long sum(long[] numberList) {
        long resultSum = 0;

        for (long number : numberList) {
            resultSum += number;
        }

        return resultSum;
    }

}
