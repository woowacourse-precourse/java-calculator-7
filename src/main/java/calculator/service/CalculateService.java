package calculator.service;

import calculator.domain.Number;

public class CalculateService {

    public static Integer calc(Number numbers){
        int result = 0;
        for(Integer number : numbers.getNumbers()){
            result += number;
        }
        return result;
    }
}
