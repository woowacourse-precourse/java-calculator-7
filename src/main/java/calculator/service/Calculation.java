package calculator.service;

import calculator.data.InputString;

import java.util.List;

public class Calculation {

    private Calculation(){}

    public static Calculation makeDefaultCalculation(){
        return new Calculation();
    }

    public Integer addOperands(InputString inputString){
        List<Integer> operands = inputString.getOperands();
        Integer result = 0;

        for(Integer operand : operands){
            result += operand;
        }
        return result;
    }
}
