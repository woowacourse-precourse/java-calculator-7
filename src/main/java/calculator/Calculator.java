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
            long tmpRes = Long.parseLong(number);
            if(tmpRes<=0){
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
