package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.numCalculator.NumCalculator;
import calculator.domain.preprocess.DelimeterProcessor;
import calculator.domain.preprocess.InputManager;
import calculator.domain.preprocess.Preprocessor;
import calculator.domain.preprocess.SplitManager;
import calculator.view.ViewManager;

public class Application {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
                new NumCalculator(),
                new Preprocessor(
                        new DelimeterProcessor(),
                        new InputManager(),
                        new SplitManager()),
                new ViewManager());

        calculatorController.runCalculator();
    }
}
