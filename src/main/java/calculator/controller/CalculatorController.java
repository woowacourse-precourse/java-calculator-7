package calculator.controller;

import calculator.util.OutputUtil;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private final OutputUtil outputUtil = new OutputUtil();
    public void startCalculating(){
        outputUtil.printProgramStart();
        String inputString = Console.readLine();
    }
}
