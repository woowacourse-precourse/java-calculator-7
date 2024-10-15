package calculator;

import java.util.List;

public class Calculator {

    private long result;

    public long calculatePlusNumber(List<String> numbers){
        for(String num : numbers){
            validator(num);
            result += Long.parseLong(num);
        }
        return result;
    }

    private void validator(String number){
        try{
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
