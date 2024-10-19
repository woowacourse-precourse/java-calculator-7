package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        StringAdditionCalculator calculator = new StringAdditionCalculator();

        io.run(calculator);
    }
}
