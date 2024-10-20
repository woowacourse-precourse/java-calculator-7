package calculator.model;

import java.util.List;

public class CalculatorService {
    private InputParser inputParser;
    private Calculator calculator;


    public CalculatorService(InputParser inputParser, Calculator calculator) {
        this.inputParser = inputParser;
        this.calculator = calculator;
    }

    public List<Integer> checkAndParseInput(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            return List.of();
        }
        if (inputParser.checkDefaultDelimiter(input)) {
            return inputParser.convertDefaultDelimiter(input);
        }
        List<Integer> list = inputParser.convertCustomDelimiter(input);
        return list;
    }

    public int calculate(List<Integer> numList) {
        return calculator.calculate(numList);
    }
}
