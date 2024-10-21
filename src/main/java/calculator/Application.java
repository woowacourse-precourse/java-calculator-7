package calculator;

public class Application {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Reader reader = new Reader();
        Writer writer = new Writer();
        Calculator calculator = new Calculator(parser, reader, writer);

        calculator.run();
    }
}
