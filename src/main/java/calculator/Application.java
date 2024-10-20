package calculator;

public class Application {
    public static void main(String[] args) {

        View view = new View();
        view.printStart();
        String input = Input.getInput();

        Calculator calculator = new Calculator();

        try {
            int result = calculator.calculate(input);
            view.printResult(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }


    }
}
