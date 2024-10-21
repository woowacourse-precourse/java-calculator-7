package calculator.model;

import calculator.validation.InputValidator;
import static calculator.controller.CalculatorController.splitters;

public class CustomSplitter {

    public String addCustomSplitter(String input){

        splitters.add(',');
        splitters.add(':');

        while (InputValidator.hasCustomSplit(input)){
            char splitter = input.charAt(2);
            InputValidator.checkSplit(splitter);
            splitters.add(splitter);
            input = input.substring(5);
        }

        return input;

    }

    public StringBuilder makeSplit(){
        StringBuilder split = new StringBuilder();
        for(char splitter : splitters){
            split.append(splitter);
        }
        return split;
    }

}
