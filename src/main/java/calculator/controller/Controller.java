package calculator.controller;

import calculator.IO.InputOutput;
import calculator.parser.ExtractNumber;
import calculator.parser.StringParser;

import static calculator.validation.Validator.validateCustomSeparator;

public class Controller {
    private final InputOutput inputOutput;
    private final StringParser stringParser;
    private final ExtractNumber extractNumber;

    public Controller(InputOutput inputOutput, StringParser stringParser, ExtractNumber extractNumber) {
        this.inputOutput = inputOutput;
        this.stringParser = stringParser;
        this.extractNumber = extractNumber;
    }

    public void calculator(){
        String input = inputOutput.inputString();
        int result = 0;

        if(!input.isEmpty()){
            validateCustomSeparator(input);
            String[] strings =  stringParser.parseInput(input);
            result = extractNumber.extractNumbers(strings);
        }

        inputOutput.outputResult(result);
    }
}
