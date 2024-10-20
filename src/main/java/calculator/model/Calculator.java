package calculator.model;

public class Calculator {

    private final Input input;
    private final CalculateSum calculateSum;
    private  final Output output;

    public Calculator() {
        this.input = new Input();
        this.calculateSum = new CalculateSum();
        this.output = new Output();
    }

    public void run() {
        output.promptForInput();

        String expression = input.readInput();
        int result = calculateSum.calculate(expression);

        output.displayResult(result);
    }
}
