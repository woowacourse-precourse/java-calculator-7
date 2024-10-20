package model;

public class CalculatorModel {
    private final Parser parser;

    public CalculatorModel(Parser parser) {
        this.parser = parser;
    }

    public int calculate(CalculatorDate date) {
        if (parser.isEmpty(date.getText())) {
            throw new IllegalArgumentException("입력이 비어 있습니다.");

        }

        int[] numbers = parser.parseNumbers(date);
        date.setSumNumbers(numbers);
        return parser.sumNumbers(date.getSumNumbers());
    }
}

