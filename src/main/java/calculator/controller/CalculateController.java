package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Tokenizer;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.ArrayList;

public class CalculateController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Tokenizer tokenizer = new Tokenizer();
    private final Calculator calculator = new Calculator();

    public void run(){
        String input = inputView.input();
        int num=0;
        ArrayList<Integer> tokens = tokenizer.tokenize(input);
        num = calculator.calculateSum(tokens);
        outputView.output(num);
    }
}
