package calculator;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        OutputHandler.printResult(Calculator.add(parser.parse(InputHandler.getInput())));
    }
}
