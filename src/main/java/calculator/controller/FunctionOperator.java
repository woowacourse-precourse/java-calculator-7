package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class FunctionOperator {
    private final InputView inputView;
    private final OutputView outputView;
    private final Preprocessing preprocessing;
    private final Calculation calculation;

    public FunctionOperator(InputView inputView, OutputView outputView, Preprocessing preprocessing, Calculation calculation)
    {
        this.inputView = inputView;
        this.outputView = outputView;
        this.preprocessing = preprocessing;
        this.calculation = calculation;
    }

    public void run() {
        // 입력 받기
        outputView.askInput();
        String input = inputView.askInput();

        // 전처리: 구분자 처리 및 숫자 추출
        List<String> separated = preprocessing.processInput(input);

        // 계산하기
        int result = calculation.calculate(separated);

        // 결과 출력
        outputView.printAnswer(result);
    }

}
