package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.model.CalculationModel;

public class CalculatorController {
    private InputView inputView;
    private OutputView outputView;
    private CalculationModel calculationModel;

    public CalculatorController(CalculationModel model, InputView inputView, OutputView outputView) {
        this.calculationModel = model;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        try{
            outputView.printInput();
            String input = inputView.getInput();
            calculationModel.parseInput(input);
            int result = calculationModel.calculateSum();
            outputView.printResult(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
