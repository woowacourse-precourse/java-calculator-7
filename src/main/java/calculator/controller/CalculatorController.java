package calculator.controller;

import calculator.model.CustomSplitter;
import calculator.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CalculatorController {

    InputView inputView = new InputView();
    CustomSplitter customSplitter;

    public static List<Character> splitters = new ArrayList<>();

    public void run(){

        String input = inputView.inputString();

        customSplitter.addCustomSplitter(input);

    }

}
