package calculator.service;

import calculator.dto.OperandDTO;
import calculator.dto.ResultDTO;

public class CalculateService {
    private static ResultDTO addOperand(OperandDTO operandDTO){
        int sum = 0;

        for(int x : operandDTO.getOperandList()){
            sum += x;
        }

        return new ResultDTO(sum);
    }
}
