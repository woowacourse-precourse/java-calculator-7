package calculator.model;

import java.util.regex.Pattern;

public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String[] splitNumbers(){
        String customDelimiter = "";
        String[] splitedNumbers;
        customDelimiter = checkCustomDelimiter();
        if(!customDelimiter.isEmpty()){
           splitedNumbers = numbers.split("[,;]|" + Pattern.quote(customDelimiter));
           return splitedNumbers;
        }
        splitedNumbers = numbers.split("[,;]");
           return splitedNumbers;
    }

    private boolean checkCustomDelimiter(){
        String[] splitedNumbers = numbers.split("[,;]");
        String engraftedNumbers = String.join("", splitedNumbers);  
        if (engraftedNumbers.matches("\\d+")){
            return true;
        }
        return false;
    }




}
