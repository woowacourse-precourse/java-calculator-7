package calculator.service;

import calculator.view.InputView;

import java.util.Arrays;

public class CalculatorService {

    static final String DESCRIPTION = "덧셈할 문자 열을 입력해 주세요.";

    private final InputView inputView;

    public CalculatorService(InputView inputView) {
        this.inputView = inputView;
    }

    public void run()
    {
        inputView.printMessage(DESCRIPTION);
        int[] validateIntArray = inputView.getUserInput();

        if (validateIntArray != null)
        {
            System.out.println("null이 아닙니당");
        }
        else
        {
            System.out.println("예외처리로 인한 null 출력");
        }
    }
}
