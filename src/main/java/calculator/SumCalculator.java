package calculator;

import java.util.regex.Pattern;

public class SumCalculator {
    int result =0;

    public void startCalculator(String userInput){
        if(userInput.isEmpty()||userInput == null) {
            System.out.println("결과 : " + result);
            return;
        }
        basicCalculator(userInput);
        System.out.println("결과 : " + result);
    }
    private int basicCalculator(String userInput){
        if(userInput.contains(",")||userInput.contains(":")) {
            String[] userNumbers = userInput.split(",|:");
            result = sum(userNumbers);
        }else{
            customDelimiterCalculator(userInput);
        }
        return result;
    }
    private int sum(String[] userNumbers) {
        for (int i = 0; i < userNumbers.length; i++) {
            result = result + isPositive(userNumbers[i]);
        }
        return result;
    }
}
