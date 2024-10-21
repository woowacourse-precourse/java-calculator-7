package calculator.operation;

import calculator.model.LongCalculatorModel;
import java.util.Arrays;

public class AdditionalLongCalculatorOperation implements LongCalculatorOperation {


    @Override
    public void operate(LongCalculatorModel model) {
        long result = Arrays.stream(model.getNumbers()).sum();
        model.setResultNumber(result);
    }
}
