package calculator.Validator;

import calculator.Model.CalculatorModel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class InputValidator {

    private String input;

    private boolean isNull(){
        return input == null;
    }



    private final CalculatorModel calculatorModel;

    public InputValidator(CalculatorModel calculatorModel){
        this.calculatorModel = calculatorModel;
    }

    private boolean isEmpty(){
        return input.trim().isEmpty();
    }

    private boolean isNumeric(String token){
        if(token == null || token.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    private boolean hasInvalidSeparator(){

        String customSeparator = null;

        if(input.startsWith("//")){
            customSeparator = input.substring(2, input.indexOf("\\n"));
            input = input.substring(input.indexOf("\\n") + 2);
        }

        String divider = calculatorModel.createTokenSeparator(customSeparator);

        String[] numberTokens = input.split(divider);

        System.out.println(divider);
        System.out.println(input);
        for(String i : numberTokens){
            System.out.println(i);
        };

        for(String token : numberTokens){
            token = token.trim();
            if(!isNumeric(token)){
                return true;
            }
        }

        return false;
    }



    public boolean isValidInput(String input){

        this.input = input;

        if(isNull() || isEmpty()){
            throw new IllegalArgumentException("입력이 null 혹은 빈 문자열 입니다.");
        }

        if(hasInvalidSeparator()){
            throw new IllegalArgumentException("틀린 입력 입니다.");
        }

        return true;
    }

}
