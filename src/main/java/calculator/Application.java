package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleOperandsProvider provider = new ConsoleOperandsProvider();
        Calculator calculator = new Calculator(provider);
        calculator.enter();
        Long sum = calculator.addAll();
        System.out.printf("결과 : %d", sum);
    }
}
