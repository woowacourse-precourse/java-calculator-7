package controller;

import model.Calculator;
import model.Tokenization;
import view.InputView;
import view.OutputView;

public class CalculatorController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final Tokenization tokenization = new Tokenization();
    private static final Calculator calculator = new Calculator();

    /**
     * 문자열 계산기를 실행 함수
     * **/
    public void run(){
        String str = inputView.input();
        int result = 0;
        // 빈 문자열이면 "0"을 반환
        if(!str.isEmpty()) {
            result = calculator.add(tokenization.tokenize(str));
        }
        outputView.output(result);
    }
}