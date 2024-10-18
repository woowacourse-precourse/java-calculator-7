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

        //커스텀 구분자 추출
        Character customDelimiter = inputParser.extractCustomDelimiter(input);
        String calculationString = inputParser.extractCalculationString(input, customDelimiter);
        List<SumValue> values = calculationStringTokenizer.tokenize(calculationString, customDelimiter);

        //정수로 변환 및 계산
        int ret = 0;

        for (SumValue sumValue : values) {
            ret += sumValue.getValue();
        }

        return ret;
    }
}
