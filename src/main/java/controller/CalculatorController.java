package controller;

import view.InputView;
import view.OutputView;

public class CalculatorController {
    //의존성 추가
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();


    /**
     * 문자열 계산기를 실행
     ***/
    public void calculate(){
        String str = inputView.input();
        int result = 0;
        outputView.output(result);

    }
}
