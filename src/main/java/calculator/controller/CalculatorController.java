package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Map;

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

        ArrayDeque<String> sepStack = calcService.detectNormalSeparator(userInput);
        if(calcService.hasSpecialSeparator(userInput)) {
            Map<String, String> specialResult = calcService.specialSepProcessing(userInput);
            sepStack.addLast(specialResult.get("sep"));
            userInput = specialResult.get("input");
        }
//        calcService.splitInputBySepStack(userInput, sepStack);

        BigInteger result = calcService.calcInput(userInput);

        calcView.printResultMsg(result);
    }
}
