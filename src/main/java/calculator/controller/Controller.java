package calculator.controller;

import calculator.model.Extractor;
import calculator.model.Numbers;
import calculator.view.InputView;

public class Controller {
    InputView inputView = new InputView();
    Extractor extractor = new Extractor();

    public void calculate(){
        String calculationValue=inputView.inputCalculationValue();
        Numbers numbers = extractor.extractValues(calculationValue);
    }
}
