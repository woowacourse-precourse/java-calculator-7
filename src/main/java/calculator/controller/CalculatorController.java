package calculator.controller;

import calculator.model.DelimiterHandler;
import calculator.model.InputParser;
import calculator.model.StringToNumberConverter;
import calculator.model.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputParser delimiterParser = new InputParser(new DelimiterHandler());
    private final StringToNumberConverter stringConverter = new StringToNumberConverter();
    private final SumCalculator sumCalculator = new SumCalculator();

    public void start() {
        String inputString = inputView.inputString();  // 사용자 입력 받기

        if (inputString.isEmpty()) {  // 입력값이 비어있을 경우 처리
            outputView.printResult("0");
            return;
        }

        String[] splitInput = delimiterParser.parseInput(inputString);  // 입력 파싱
        long[] numericValues = stringConverter.convertToNumbers(splitInput);  // 숫자 변환
        String totalSum = sumCalculator.calculateSum(numericValues);  // 합 계산

        outputView.printResult(totalSum);  // 결과 출력
    }
}
