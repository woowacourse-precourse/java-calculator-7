package calculator.Controller;

import calculator.Interface.Calculator;
import calculator.Interface.Parser;
import calculator.Interface.Validator;
import calculator.View.InputView;
import calculator.View.OutputView;

public class CalculatorController {

    private final Calculator calculator;
    private final Validator validator;
    private final Parser parser;

    public CalculatorController(Calculator calculator, Validator validator, Parser parser){
        this.calculator = calculator;
        this.validator = validator;
        this.parser = parser;
    }

    public void run(){

        String userInput = InputView.userInput();

        try{
            parser.setInput(userInput);

            parser.parseCustomSeparator();

            String[] tokens = parser.getTokens();

            validator.validateTokens(tokens);

            String result = calculator.calculateSum(tokens);

            OutputView.userOutput(result);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
}
