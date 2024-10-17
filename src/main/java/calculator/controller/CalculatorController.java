package calculator.controller;

import calculator.domain.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    public CalculatorController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void startCalculator(){
        outputView.printInputNumbers();
        List<Integer> splitNumbers = inputView.inputNumbers();
        Numbers sumNum = new Numbers(splitNumbers);
        int result = sumNum.addNumbers(splitNumbers);
        outputView.printGameResult(result);
    }
}
