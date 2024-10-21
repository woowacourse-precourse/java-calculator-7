package calculator.model;

import calculator.validation.InputValidator;
import static calculator.controller.CalculatorController.splitters;

public class CustomSplitter {

    public void addCustomSplitter(String input){

        splitters.add(',');
        splitters.add(':');

        while (InputValidator.hasCustomSplit(input)){
            char splitter = input.charAt(2);
            InputValidator.checkSplit(splitter);
            splitters.add(splitter);
            input = input.substring(5);
        }

    }

}
