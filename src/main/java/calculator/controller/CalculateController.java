package calculator.controller;


import calculator.model.CalculateModel;
import calculator.model.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;


public class CalculateController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;
    private final CalculateModel calculateModel;

    public CalculateController(InputView inputView, OutputView outputView, Parser parser,
                               CalculateModel calculateModel) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
        this.calculateModel = calculateModel;
    }

    // 전체 로직 실행
    public void calculate() {

        // 문자열 입력
        String inputString = inputView.getInputString();

        // 문자열 파싱
        parser.parseString(inputString);

        // 덧셈 연산
        int result = calculateModel.sum(parser.getOperands());

        // 결과 출력
        outputView.printResult(result);


    }

}
