package calculator;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        view.printStart();
        String input = Input.getInput();

        Adder adder = new Adder();
        Delimiters delimiters = new Delimiters();
        Calculator calculator = new Calculator(adder, delimiters);

        try {
            int result = calculator.calculate(input);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
