package calculator;

import calculator.domain.DelimiterParser;
import calculator.domain.InputParser;
import calculator.domain.StringSplitter;
import calculator.domain.SumCalculator;
import calculator.domain.controller.CalculatorController;
import calculator.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputParser inputParser = new InputParser();
        DelimiterParser delimiterParser = new DelimiterParser();
        StringSplitter stringSplitter = new StringSplitter();
        SumCalculator sumCalculator = new SumCalculator();
        CalculatorController calculatorController = new CalculatorController(inputParser, delimiterParser,
                stringSplitter, sumCalculator);
        String input = InputView.input();
        calculatorController.run(input);
    }
}
