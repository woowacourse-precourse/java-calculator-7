package calculator;

public class MainController {
    public static void run() {
        String input = Input.readInput();
        input = Validator.validateInput(input);

        Calculator calculator = new Calculator();
//        calculator.checkInput();
        calculator.splitInput(input);
        calculator.addNumbers();

        Output.printResult(calculator.getSum());
    }
}
