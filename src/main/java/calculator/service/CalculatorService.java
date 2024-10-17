package calculator.service;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorService {

    static final String INPUT_DESCRIPTION = "덧셈할 문자 열을 입력해 주세요.";

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run()
    {
        inputView.printMessage(INPUT_DESCRIPTION);
        int[] validateIntArray = inputView.getUserInput();

        if (validateIntArray != null)
        {

            System.out.println(outputView.sumElements(validateIntArray));
        }
        else
        {
            System.out.println("예외처리로 인한 null 출력");
        }
    }
}
