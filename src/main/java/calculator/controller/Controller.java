package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Extractor;
import calculator.model.Numbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    Extractor extractor = new Extractor();
    Calculator calculator = new Calculator();
    OutputView outputView = new OutputView();

    public void calculate(){
        String calculationValue=inputView.inputCalculationValue();
        extractor.extractValues(calculationValue);
        //Numbers numbers = extractor.extractValues(calculationValue);
        //int resultValue=calculator.plusCalculator(numbers);
        //outputView.printResultValue(resultValue);
    }
}
