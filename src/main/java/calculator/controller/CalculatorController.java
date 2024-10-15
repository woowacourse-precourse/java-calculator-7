package calculator.controller;

import calculator.util.Utils;
import calculator.view.InputView;

import java.lang.reflect.Array;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorController {

    public void start(){
        beforeCalculate();

    }

    public void beforeCalculate(){
        String[] splitStringArr = Utils.splitStringToArray(inputString());
        System.out.println(Arrays.toString(splitStringArr));
    }

    private String inputString(){
        InputView.printInputCalculateStringMessage();
        return readLine().trim();
    }
}

