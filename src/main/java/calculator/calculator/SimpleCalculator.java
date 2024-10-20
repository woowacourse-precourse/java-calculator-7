package calculator.calculator;


import calculator.Validator;
import java.util.Arrays;

public class SimpleCalculator {

    private static final String DEFAULT_SPLIT_REGEX = "[,:]";

    public int calculate(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }
        String[] split = inputString.split(DEFAULT_SPLIT_REGEX);
        int[] intArray = Validator.validateToIntArray(split);
        Validator.checkHasNotPositive(intArray);
        return Arrays.stream(intArray).sum();
    }


}
