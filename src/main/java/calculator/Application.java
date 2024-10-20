package calculator;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        Calculator calculator = new Calculator();

        prompt.getCommand(calculator);
    }
}
