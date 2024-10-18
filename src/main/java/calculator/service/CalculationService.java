package calculator.service;

public class CalculationService {

    public long sum(long[] operands) {

        long result = 0;

        for(long operand : operands) {
            result += operand;
        }

        return result;
    }
}
