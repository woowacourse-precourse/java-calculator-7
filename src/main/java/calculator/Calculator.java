package calculator;

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
        while(true) {
            try {
                outputView.printCalculatorStartMessage();
                inputView.readText();
            }catch (IllegalArgumentException e){
                break;
            }
        }
    }
}
