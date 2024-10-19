package calculator;

public class Calculator {
    private int result;

    public Calculator() {}

    public void run(){
        Output.printUserInput();
        String inputData = Input.getUserInput();
        this.result = Calculation.getCalculationResult(inputData);
    }

    public void end(){
        Output.printResult(this.result);
    }
}
