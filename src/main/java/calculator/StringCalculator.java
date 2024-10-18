package calculator;

import java.util.List;

public class StringCalculator {

    private InputParser inputParser;
    private CalculationStringTokenizer calculationStringTokenizer;

    public StringCalculator() {
        this.inputParser = new InputParser();
        this.calculationStringTokenizer = new CalculationStringTokenizer();
    }

    public int calculate(String input) {
        InputString inputString = new InputString(input);
        CustomDelimiter customDelimiter = inputString.extractCustomDelimiter();
        String calculationString = inputString.extractCalculationString();
        List<SumValue> values = calculationStringTokenizer.tokenize(calculationString, customDelimiter);

        //정수로 변환 및 계산
        int ret = 0;

        for (SumValue sumValue : values) {
            ret += sumValue.getValue();
        }

        return ret;
    }
}
