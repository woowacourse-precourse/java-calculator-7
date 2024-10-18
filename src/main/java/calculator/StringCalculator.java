package calculator;

import java.util.List;

public class StringCalculator {

    public int calculate(String input) {
        InputString inputString = new InputString(input);
        CustomDelimiter customDelimiter = inputString.extractCustomDelimiter();
        CalculationString calculationString = inputString.extractCalculationString();
        List<SumValue> values = calculationString.getSumValues(customDelimiter);

        //정수로 변환 및 계산
        int ret = 0;

        for (SumValue sumValue : values) {
            ret += sumValue.getValue();
        }

        return ret;
    }
}
