package calculator.controller;

import calculator.service.StringFacadeService;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigInteger;

/**
 * 사용자로부터 입력을 받고 비즈니스 로직을 실행하고 결과를 콘솔에 출력한다.
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

    /**
     * 프로그램 시작
     */
    public void start() {
        String input = inputView.getUserInput();
        if (input.isEmpty()) {
            // 입력이 없는 경우 비즈니스 로직을 실행할 필요 없음.
            outputView.displayResultZero();
        } else {
            // 입력이 있다면 비즈니스 로직을 실행한다.
            BigInteger answer = stringFacadeService.addNumbersFromInput(input);
            outputView.displayResult(answer);
        }
    }
}
