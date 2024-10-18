package calculator;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        StringParser parser = new StringParser();
        Calculator calculator = new Calculator();

        prompt.getCommand(parser, calculator);
    }
}
