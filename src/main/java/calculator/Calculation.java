package calculator;

import java.util.List;

public class Calculation {

    public Integer addOperands(InputString inputString){
        List<Integer> operands = inputString.getOperands();
        Integer result = 0;

        for(Integer operand : operands){
            result += operand;
        }
        return result;
    }
}
