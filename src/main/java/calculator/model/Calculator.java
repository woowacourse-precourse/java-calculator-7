package calculator.model;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    private String numbers;

    public Calculator(String numbers){
        this.numbers = numbers;
    }

    public String getNumbers(){
        return this.numbers;
    }

    public String[] splitNumbers(){
        String customDelimiter = "";
        if(checkCustomDelimiter()){
            customDelimiter = getCustomDelimiter();
            this.numbers = SplitDelimiter(numbers);
            return numbers.split("[,;]|" + Pattern.quote(customDelimiter));
        }
            return numbers.split("[,;]");
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
        Pattern pattern = Pattern.compile("//(.*?)\n");
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

    public String SplitDelimiter(String numbers){
        String[] splitedNumbers = numbers.split("\n");
        return splitedNumbers[1];
    }
}
