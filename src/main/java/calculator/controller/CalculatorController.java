package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;

public class CalculatorController {

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
        //FIXME: 컨트롤러에 로직이 들어가지 않도록
        if (calcService.hasSpecialSeparator(userInput)) {
            Map<String, String> specialResult = calcService.specialSepProcessing(userInput);
            sepStack.addLast(specialResult.get("sep"));
            userInput = specialResult.get("input");
        }

        ArrayList<String> splitResult = calcService.processingInputBySepStack(userInput, sepStack);
        BigInteger result = calcService.calcSplitResult(splitResult);

        calcView.printResultMsg(result);
    }
}
