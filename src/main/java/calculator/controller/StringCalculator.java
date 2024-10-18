package calculator.controller;

import calculator.domain.DelimiterExtractor;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.ResultCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class StringCalculator {
    private InputView inputView;
    private OutputView outputView;
    private DelimiterExtractor delimiterExtractor;
    private DelimiterTokenizer delimiterTokenizer;
    private ResultCalculator resultCalculator;

    public StringCalculator(InputView inputView, OutputView outputView, DelimiterExtractor delimiterExtractor,
                            DelimiterTokenizer delimiterTokenizer, ResultCalculator resultCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterExtractor = delimiterExtractor;
        this.delimiterTokenizer = delimiterTokenizer;
        this.resultCalculator = resultCalculator;
    }
}
