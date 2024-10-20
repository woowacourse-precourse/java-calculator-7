package calculator;

import java.math.BigInteger;

/**
 * 사용자로부터 입력을 받고 주요한 연사
 */
public class StringController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringFacadeService stringFacadeService;


    public StringController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringFacadeService = new StringFacadeService();
    }

    public void start() {
        String input = inputView.getUserInput();
        if (input.isEmpty()) {
            outputView.displayResultZero();
        } else {
            BigInteger answer = stringFacadeService.addNumbersFromInput(input);
            outputView.displayResult(answer);
        }
    }
}
