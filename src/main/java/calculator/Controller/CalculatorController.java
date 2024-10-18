package calculator.Controller;

import calculator.Interface.Calculator;
import calculator.Interface.Parser;
import calculator.Interface.Validator;
import calculator.View.InputView;
import calculator.View.OutputView;

import java.util.Arrays;

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

            // 구분자, 숫자 분리
            parser.parseCustomSeparator();

            // 구분자로 숫자 분리
            String[] tokens = parser.getTokens();

            System.out.println(Arrays.toString(tokens));

            //공백, 빈값, 음수, 숫자에 대한 validation
            validator.validateTokens(tokens);

            // string addition
            String result = calculator.calculateSum(tokens);

            OutputView.userOutput(result);

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
}
