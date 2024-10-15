package calculator.controller;

import calculator.view.InputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorController {

    public void start(){

    }

    public void beforeCalculate(){

    }

    private void inputString(){
        InputView.printInputCalculateStringMessage();
        String input = readLine().trim();

    }
}
