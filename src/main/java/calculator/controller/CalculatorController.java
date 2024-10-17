package controller;

import model.Custom;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController() {
        Custom custom = new Custom();
        this.inputView = new InputView(custom);
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printReadNumberMessage();
        inputView.readInputString();
        String parsingInputString = inputView.getInputString();
        parsingCalculatorInput(parsingInputString);
        String result = calculatorAddFeature();
        outputView.printCalculatorResultMessage(result);
    }

    private void parsingCalculatorInput(String parsingInputString) {
        /**
         *커스텀을 기준으로 split을 진행하고 split의 값이 숫자가 아닌 경우 예외처리를 진행해주고
         *숫자인 경우 Array 동적 set에 담아주어야함"
         *문자열 숫자의 길이를 생각해야함.
         * 매우 큰 문자열 숫자의 경우도 확인할 수 있어야 함
         */
    }

    private String calculatorAddFeature() {
        /**
         * 계산을 진행
         * 매우 큰 수의 경우에도 더하기가 가능해야 하기 때문에
         * String 더하기를 구현
         */
        return null;
    }


}
