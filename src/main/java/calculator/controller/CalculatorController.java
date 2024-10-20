package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorController {
    //TODO: 사용자의 입력에 대한 처리를 진행하는 클래스

    private final CalculatorView calcView;
    private final CalculatorService calcService;

    public CalculatorController(CalculatorView calcView, CalculatorService calcService) {
        this.calcView = calcView;
        this.calcService = calcService;
    }

    public void start() {

        calcView.printStartMsg();
        String userInput = calcView.getUserInput();

        //TODO: 구분자 찾기, split
        calcService.detectSeparator(userInput);
        BigInteger result = calcService.calcInput(userInput);

        calcView.printResultMsg(result);

    }
}
