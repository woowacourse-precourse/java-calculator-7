package calculator;

public class Calculator {

    private String input;
    private InputParser inputParser;
    private Evaluator evaluator;

    public Calculator(String input, InputParser inputParser, Evaluator evaluator) {
        this.input = input;
        this.inputParser = inputParser;
        this.evaluator = evaluator;
    }

    public void run() {
        String formula = inputParser.findCustomSeparator(input);
        evaluator.getResult(formula, inputParser.getSeparators());
    }
}
