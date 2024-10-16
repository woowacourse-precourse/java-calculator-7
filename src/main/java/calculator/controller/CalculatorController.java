package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorController {
    private Calculator calculator;

    public void run(){
        startCalculate();
        
    }

    public void startCalculate(){
        calculator = new Calculator(inputString());
    }

    private String inputString(){
        InputView.printInputCalculateStringMessage();
        return readLine().trim();
    }


}

