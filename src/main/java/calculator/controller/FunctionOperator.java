package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class FunctionOperator {
    private final IOProcessor ioProcessor;
    private final Calculation calculation;

    public FunctionOperator(IOProcessor ioProcessor, Calculation calculation) {
        this.ioProcessor = ioProcessor;
        this.calculation = calculation;
    }

    public void run() {
        // 전처리 및 입력 받기
        List<String> separated = ioProcessor.processInput();

        // 계산하기
        int result = calculation.calculate(separated);

        // 결과 출력
        ioProcessor.displayResult(result);
    }

}
