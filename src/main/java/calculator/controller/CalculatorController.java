package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private Calculator calculator;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        inputString();
        validateNull();
        parseNumbers();
    }

    public void inputString(){
        outputView.printInputMessage();
        calculator = new Calculator(inputView.getInput());
    }

    public void validateNull(){
        if(calculator.validateNull())
            outputView.printAnswerMessage(calculator.getAnswer());
    }

    public void parseNumbers(){
        calculator.parseNumbers();
    }

    public void validateNumbers(){

    }
    public void sumNumbers(){

    }

    public void outputResult() {

    }

    //inputString: 사용자의 문자열 입력을 받음
    //strToInt: 문자열을 구분자로 나눠 숫자 배열로 변환
    //validateNumbers: 배열에서 음수가 있는지 검사
    //sumNumbers: 숫자 배열을 합산
    //outputResult: 결과를 출력
}
