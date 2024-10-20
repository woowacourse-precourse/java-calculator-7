package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final InputView inputView;

    public CalculatorController(CalculatorService calculatorService, InputView inputView){
        this.calculatorService =calculatorService;
        this.inputView =inputView;
    }

    /**
     * 계산기 프로그램 실행 시 실행되는 메소드.
     * @return
     */
    public void start(){
        String inputString = InputStringFromInputView();
        calculatorService.calculate(inputString);
    }


    /**
     * view 패키지의 InputView 로부터 사용자 입력을 받아오는 메소드.
     * @return : InputView 로 얻은 String.
     */
    private String InputStringFromInputView(){
        return inputView.InputString();
    }

}
