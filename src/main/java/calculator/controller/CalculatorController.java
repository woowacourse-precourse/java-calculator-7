package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomSplitter;
import calculator.model.ExtractString;
import calculator.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorController {

    InputView inputView = new InputView();
    CustomSplitter customSplitter;
    ExtractString extractString;
    Calculator calculator;

    public static List<Character> splitters = new ArrayList<>();

    public void run(){

        String input = inputView.inputString();

        customSplitter.addCustomSplitter(input);

        StringBuilder split = customSplitter.makeSplit();

        StringTokenizer st = extractString.ExtractInput(input, split);

        long ans = calculator.calculate(st);
    }

}
