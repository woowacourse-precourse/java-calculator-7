package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Tokenizer;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class CalculateController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Calculator calculator = new Calculator();

    public void run(){
        String input = inputView.input();
        ArrayList<Integer> tokens = Tokenizer.tokenize(input);
        int num = calculator.calculateSum(tokens); // 바로 값 할당
        outputView.output(num);
    }
}