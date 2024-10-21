package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Parser parser = new Parser();
    Calculator calculator = new Calculator();

    public void start() {
        outputView.printStart();
        String inputString = inputView.inputString();
        List<Integer> valueList = parser.parseInput(inputString);

        int result = calculator.sum(valueList);
        outputView.print(result);
    }

}
