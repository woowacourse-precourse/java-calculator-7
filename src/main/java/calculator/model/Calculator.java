package calculator.model;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String splitNumbers(){
        String customDelimiter = "";
        String[] splitedNumbers;
        if(checkCustomDelimiter()){
            customDelimiter = getCustomDelimiter();
            splitedNumbers = numbers.split("[,;]|" + Pattern.quote(customDelimiter));
            return plus(splitedNumbers);
        }
        splitedNumbers = numbers.split("[,;]");
           return plus(splitedNumbers);
    }

    public boolean checkCustomDelimiter(){
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

    private String plus(String[] splitedNumbers){
        int sumOfNumbers = 0;
        for (int i = 0; i < splitedNumbers.length; i++) {
            int intNumber = Integer.parseInt(splitedNumbers[i]);
            sumOfNumbers = sumOfNumbers + intNumber;
        }
        return String.valueOf(sumOfNumbers);
    }


    
}
