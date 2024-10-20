package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private Pattern customString;
    public Calculator(){
        this.customString = Pattern.compile(":|,");
    }
    public Calculator(String customString){
        this.customString = Pattern.compile(":|,|" + customString);
    }

    String[] parseString(String input){
        return input.split(customString.pattern());
    }

    double calculate(String[] inputString){
        double sum = 0;
        for(String number : inputString){
            double doubleNumber = Double.parseDouble(number);
            sum += doubleNumber;
        }
        return sum;
    }
}
