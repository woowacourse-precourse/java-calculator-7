package calculator;

import calculator.domain.Result;
import calculator.ui.InputView;
import calculator.ui.OutputView;

public class Calculator {
    private final InputView inputView;
    private final OutputView outputView;
    public Calculator(InputView inputView,OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        outputView.printCalculatorStartMessage();
        Result result = inputView.readText();
        int total = result.getTotal();
        outputView.printCalculatorsRESULTMessage(total);
    }
}
