package calculator.controller;


import calculator.model.CalculateModel;
import calculator.view.CalculateView;

public class CalculateController {

    // 전체 로직 실행
    public void calculate(CalculateView calculateView, CalculateModel calculateModel, Parser parser) {

        // 문자열 입력
        String inputString = calculateView.getInputString();

        // 문자열 파싱
        parser.parseString(inputString);

        // 덧셈 연산
        int result = calculateModel.sum(parser.getOperands());

        // 결과 출력
        calculateView.printResult(result);
    }

}
