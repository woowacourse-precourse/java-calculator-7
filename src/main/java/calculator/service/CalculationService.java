package calculator.service;

import calculator.model.Operand;
import calculator.model.Result;

public class CalculationService {

    public Result sum(Operand[] operands) {

        Result result = new Result(0);

        for (Operand operand : operands) {
            result.add(operand.getNumber());
        }

        return result;
    }
}
