package calculator.service;

import calculator.Model.Input;

public class CalculatorService {

    /**
     * 사용자로부터 얻어온 String을 계산하는 로직
     */
    public Number calculate(Input input){
        double sum = input.sum();
        return checkInteger(sum);
    }

    /**
     * 합계가 정수형인지 실수형인지 판단
     */
    Number checkInteger(double sum){
        if(sum %1 ==0){
            return (int) sum;
        }
        else{
            return sum;
        }
    }


}
