package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String message = calculator.calculate();
        System.out.println(message);
    }
}
