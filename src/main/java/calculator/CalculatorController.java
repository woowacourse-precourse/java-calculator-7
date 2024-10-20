package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private OutputView outputView;
    private InputView inputView;
    private CalculatorManager manager;
    private Double result;

    public CalculatorController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.manager = new CalculatorManager();
    }

    public void run(){
        outputView.printStartMessage();
        String readString = inputView.readUserString();
        StringProcessor processor = new StringProcessor(readString);
        result = manager.plus(processor.getNumberList());
        if (result % 1 == 0) {
            outputView.resultIntegerMessage(result);
            return;
        }
        outputView.resultDoubleMessage(result);
    }
}
