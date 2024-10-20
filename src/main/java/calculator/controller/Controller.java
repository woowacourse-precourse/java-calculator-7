package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.OutPutView;

public class Controller {
    private final InputView inputView;
    private final OutPutView outputView;
    private final Calculator calculator;

    public Controller(InputView inputView, OutPutView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }
}
