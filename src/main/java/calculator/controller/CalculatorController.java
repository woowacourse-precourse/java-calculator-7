package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(CalculatorService calculatorService, InputView inputView,OutputView outputView){
        this.calculatorService =calculatorService;
        this.inputView =inputView;
        this.outputView = outputView;
    }

    /**
     * 계산기 프로그램 실행 시 실행되는 메소드.
     * @return
     */
    public void start(){
        String inputString = InputStringFromInputView();
        int result = calculatorService.calculate(inputString);
        outputView.result(result);
    }


    /**
     * view 패키지의 InputView 로부터 사용자 입력을 받아오는 메소드.
     * @return : InputView 로 얻은 String.
     */
    private String InputStringFromInputView(){
        return inputView.InputString();
    }

}
