package calculator;

public class Calculator {
    private static Calculator calculator;

    private Input input;
    private Output output;
    private Calculation calculation;

    private Calculator() {
        input = new Input();
        output = new Output();
        calculation = new Calculation();

        calculator = this;
    }

    public static Calculator getInstance() {
        if(calculator == null) {
            synchronized (Calculator.class) {
                if(calculator == null) {
                    calculator = new Calculator();
                }
            }
        }
        return calculator;
    }

    public void on() {
        String input = getInput();
        int calculation.calculate(input);
        output.print(calculation);
    }

    public String getInput() {
        return input.getInput();
    }
}
