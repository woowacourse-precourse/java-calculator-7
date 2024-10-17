package calculator.service;

import calculator.view.InputView;

public class CalculatorService {

    static final String DESCRIPTION = "덧셈할 문자 열을 입력해 주세요.";

    private final InputView inputView;

    public CalculatorService(InputView inputView) {
        this.inputView = inputView;
    }

    public void run()
    {
        inputView.printMessage(DESCRIPTION);
    }
}
