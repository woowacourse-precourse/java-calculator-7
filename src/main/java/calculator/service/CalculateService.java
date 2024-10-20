package calculator.service;

import calculator.domain.NumberValue;

public class CalculateService {

    public static int calc(NumberValue numbers){
        int result = 0;
        for(Integer number : numbers.getNumbers()){
            result += number;
        }
        return result;
    }
}
