package calculator.model;

import java.util.List;

public class Calculator {

    private double result;

    public double calculatePlusNumber(List<String> numbers){
        for(String num : numbers){
            validator(num);
            result += Double.parseDouble(num);
        }
        return result;
    }

    private void validator(String number){
        try{
            double tmpRes = Double.parseDouble(number);
            if(tmpRes<=0){
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
