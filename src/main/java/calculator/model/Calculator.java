package calculator.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String[] splitNumbers(){
        String customDelimiter = "";
        String[] splitedNumbers;
        customDelimiter = checkCustomDelimiter(numbers);
        if(!customDelimiter.isEmpty()){
           splitedNumbers = numbers.split("[,;]|" + Pattern.quote(customDelimiter));
           return splitedNumbers;
        }
        splitedNumbers = numbers.split("[,;]");
           return splitedNumbers;
    }
}
