package calculator;

public class Calculator {
    private int result;

    Calculator() {}

    void run() {
        Output.printInputRequest();
        String inputData = Input.getUserInput();
        this.result = Calculation.getCalculationResult(inputData);
    }

    void end() {
        Output.printResult(this.result);
    }
}
