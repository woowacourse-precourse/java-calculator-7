package calculator.controller;

import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    //TODO: 사용자의 입력에 대한 처리를 진행하는 클래스

    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void start() {

        view.printStartMsg();
        String userInput = view.getUserInput();

        //TODO: input을 기반으로 Service에서 처리

        //view.printResultMsg(result); TODO: 결과 출력

    }
}
