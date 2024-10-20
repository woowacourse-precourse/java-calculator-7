package calculator;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Calculator calculator = new Calculator();
        String input = console.readCalcLine();
        int result = calculator.calc(input);
        console.writeCalcResult(result);
    }
}
