package calculator.controller;

import calculator.model.Adder;
import calculator.model.Number;
import calculator.model.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    public void run(){
        List<String> input = InputView.getInput();
        Adder adder = new Adder();
        Separator separator;

        if (input.get(0) == null)
            separator = new Separator();
        else
            separator = new Separator(input.get(0).charAt(0));

        List<Number> numbers = separator.separate(input.get(1));
        Long result = adder.addAll(numbers);
        OutputView.printResult(result);
    }
}
