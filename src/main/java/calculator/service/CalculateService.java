package calculator.service;

import calculator.domain.Operands;
import calculator.dto.ResultDTO;

public class CalculateService {
    public static ResultDTO addOperand(Operands operandDTO){
        int sum = 0;

        for(int x : operandDTO.getOperandList()){
            sum += x;
        }

        return new ResultDTO(sum);
    }
}
