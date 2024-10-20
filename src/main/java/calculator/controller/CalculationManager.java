package calculator.controller;

import calculator.domain.InputData;
import calculator.view.CalculationView;

public class CalculationManager {

    public void run() {
        String input = CalculationView.input();
        InputData inputData = new InputData(input);
        CalculationView.output(inputData.sum());
    }
}
