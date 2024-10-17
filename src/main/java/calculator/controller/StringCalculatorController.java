package calculator.controller;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.InputData;
import calculator.view.InputView;

public class StringCalculatorController {
    private final InputView inputView;

    public StringCalculatorController() {
        this.inputView = new InputView();
    }

    public InputData handoverInput(){
        String input = inputView.InputData();
        return new InputData(input);
    }

    public Delimiter createDelimiterPart(InputData inputData){
        if(inputData.isDelimiter()) {
            return new CustomDelimiter();
        }

        return new DefaultDelimiter();
    }
}
