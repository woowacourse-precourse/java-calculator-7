package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Delimeter;
import calculator.model.Split;
import calculator.model.ValidationTest;
import calculator.view.InputView;
import calculator.view.OutputView;

public class SplitController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;
    private final ValidationTest validationTest;

    public SplitController() {
        this.calculator = Calculator.getInstance();
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.validationTest = ValidationTest.getInstance();
    }

    public void process(){
        //입력
        String input = inputView.input();

        //구분자 class 생성
        Delimeter delimeter = new Delimeter();

        //구분자 class를 이용해 구분자 추출하고, input 반환
        input = delimeter.setDelimeter(input);

        //구분자를 이용하여 문자열 분리
        Split split = new Split(input);
        String splitedString = split.splitString(delimeter.getValues());

        //남은 문자열의 유효성 검사
        validationTest.stringValidationTest(splitedString);

        //분리된 문자열 합 구함
        int sum = calculator.sum(splitedString);
        outputView.output(sum);


    }
}
