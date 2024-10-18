package calculator.controller;

import calculator.IO.InputOutput;
import calculator.parser.StringParser;

public class Controller {
    private InputOutput inputOutput;
    private StringParser stringParser;

    public Controller(InputOutput inputOutput, StringParser stringParser) {
        this.inputOutput = inputOutput;
        this.stringParser = stringParser;
    }

    public void calculator(){
        String input = inputOutput.inputString();
        int result = 0;

        if(!input.isEmpty()){
            result = stringParser.extractionNumber(input);
        }

        inputOutput.outputResult(result);
    }

}
