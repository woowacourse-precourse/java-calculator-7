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
}
