package calculator.Model;

import DTO.ParsedInputDTO;
import calculator.Validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CalculatorModel {

    public String createTokenSeparator(String customSeparator){
        return customSeparator == null ? "[,;]" : "[,;" + customSeparator + "]";
    }

    private String getCustomSeparator(String input){
        String customSeparator = null;
        if(input.startsWith("//")){
            int customEndIdx = input.indexOf("\\n");
            if(customEndIdx != -1){
                customSeparator = input.substring(2, customEndIdx);
            }
        }
        return customSeparator;
    }

    public ParsedInputDTO parseInput(String input){

        ArrayList<String> separators = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        String customSeparator = getCustomSeparator(input);

        separators.add(",");
        separators.add(";");

        if(customSeparator != null){
            separators.add(input.substring(2,3));
            input = input.substring(input.indexOf("\\n") + 2);
        }

        String tokenSeparator = createTokenSeparator(customSeparator);
        String[] tokens = input.split(tokenSeparator);


        for(String token : tokens){
            numbers.add(Integer.parseInt(token));
        }

        return new ParsedInputDTO(separators, numbers);
    }


}
