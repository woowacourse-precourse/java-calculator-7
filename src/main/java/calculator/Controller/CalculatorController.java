package calculator.Controller;

import calculator.Model.CalculatorModel;
import calculator.Service.InputParser;
import calculator.Validator.InputValidator;
import calculator.View.InputView;
import calculator.View.OutputView;

import java.util.Arrays;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final InputValidator inputValidator;

    public CalculatorController(){
        this.calculatorModel = new CalculatorModel();
        this.inputValidator = new InputValidator();
    }

    public void run(){

        String userInput = InputView.userInput();
        try{

            InputParser inputParser = new InputParser(userInput);

            String[] tokens = inputParser.getTokens();

            inputValidator.validateTokens(tokens);

            String result = calculatorModel.calculateSum(tokens);

            OutputView.userOutput(result);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
}
