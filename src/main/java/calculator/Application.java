package calculator;

public class Application {
    public static void main(String[] args) {
        StringAdditionCalculator application = new StringAdditionCalculator(
                new InputHandler(),
                new OutputHandler()
        );
        application.run();
    }
}