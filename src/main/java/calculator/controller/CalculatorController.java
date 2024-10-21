package calculator.controller;

import calculator.model.Calculator;
import calculator.model.CustomSplitter;
import calculator.model.ExtractString;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CustomSplitter customSplitter = new CustomSplitter();
    ExtractString extractString = new ExtractString();
    Calculator calculator = new Calculator();

    public static List<Character> splitters = new ArrayList<>();

    public void run(){

        String input = inputView.inputString();

        input = customSplitter.addCustomSplitter(input);

        StringBuilder split = customSplitter.makeSplit();

        StringTokenizer st = extractString.ExtractInput(input, split);

        long ans = calculator.calculate(st);

        outputView.printAnswer(ans);
    }

}
