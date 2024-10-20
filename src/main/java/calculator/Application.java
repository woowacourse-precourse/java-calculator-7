package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        StringCalculator calculator = new StringCalculator();

        io.run(calculator);
    }
}
