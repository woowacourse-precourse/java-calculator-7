package calculator.model;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String[] splitNumbers(){
        String customDelimiter = "";
        String[] splitedNumbers;
        if(checkCustomDelimiter()){
            customDelimiter = getCustomDelimiter();
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

    private String getCustomDelimiter(){
        Pattern pattern = Pattern.compile("//(.*?)n//");
        Matcher matcher = pattern.matcher(numbers);
        return matcher.group(1);
    }
}
