package calculator;

import calculator.controller.StringCalculator;
import calculator.domain.DelimiterExtractor;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.ResultCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();
        ResultCalculator resultCalculator = new ResultCalculator();
        StringCalculator stringCalculator = new StringCalculator(inputView, outputView, delimiterExtractor, delimiterTokenizer, resultCalculator);

        stringCalculator.run();
    }
}
