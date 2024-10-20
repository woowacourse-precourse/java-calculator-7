package calculator;


public class Calculator {

    private final InputParser inputParser = new InputParser();

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        return inputParser.parseInputToIntList(input)
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
