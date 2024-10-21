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

        return operands.stream()
                .reduce(0, (a,b) -> a+b);
    }
}
