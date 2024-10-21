package calculator.controller;

import calculator.model.CustomSplitter;
import calculator.model.ExtractString;
import calculator.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    InputView inputView = new InputView();
    CustomSplitter customSplitter;
    ExtractString extractString;

    public static List<Character> splitters = new ArrayList<>();

    public void run(){

        String input = inputView.inputString();

        customSplitter.addCustomSplitter(input);

        extractString.ExtractInput(input, customSplitter.makeSplit());



    }

}
