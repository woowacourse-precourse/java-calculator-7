package calculator.model;

import java.util.List;

public class CalculatorService {
    private InputParser inputParser = new InputParser();
    private SumCalculator sumCalculator = new SumCalculator();
    public static final int ZERO = 0;

    public List<Integer> checkAndParseInput(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            return List.of(ZERO,ZERO);
        }
        if (inputParser.checkDefaultDelimiter(input)) {
            return inputParser.convertDefaultDelimiter(input);
        }
        return inputParser.convertCustomDelimiter(input);
    }

    public int calculate(List<Integer> numList) {
        return sumCalculator.calculate(numList);
    }
}
