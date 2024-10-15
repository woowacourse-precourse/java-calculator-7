package calculator.controller;

import calculator.model.Numbers;
import calculator.model.Separator;
import calculator.validator.InputValid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateController {
    private Separator sep;
    private Numbers numbers;
    public CalculateController() {
        this.sep = new Separator();
        this.numbers = new Numbers();
    }

    public void input(String input){
        InputValid.checkStringLength(input);

        if(InputValid.checkStartWithCustomSeparator(input)){
            Matcher matcher = separateInput(input);
            String separator = matcher.group(1);
            InputValid.checkCustomSeparatorLength(separator);
        }
    }

    public Matcher separateInput(String input){
        String regex = "^//(.*?)\n(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher;
    }


    public String extractSeparator(String input){

    }

}
