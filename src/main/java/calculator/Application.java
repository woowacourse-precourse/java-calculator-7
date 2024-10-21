package calculator;

import calculator.addition.IntegerAdditionCalculator;
import calculator.io.Input;
import calculator.io.Output;
import calculator.separator.StringSeparator;
import calculator.utils.ListConverterUtil;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Output.printInputGuide();

        String inputString = Input.readLine();

        StringSeparator stringSeparator = new StringSeparator(inputString);
        List<String> strings = stringSeparator.separate();
        List<Integer> integers = ListConverterUtil.convertToPositiveIntegers(strings);

        int result = IntegerAdditionCalculator.calculation(integers);

        Output.printCalculationResult(result);
    }
}
