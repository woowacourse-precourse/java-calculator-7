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
            double doubleNumber;
            try{
                doubleNumber = Double.parseDouble(number);
            }catch (Exception e){
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
            if (doubleNumber <= 0){
                throw new IllegalArgumentException("양수만 계산 가능합니다.");
            }
        }
        return sum;
    }
}
