package calculator;

public class Application {
    private static final Calculator calculator;

    static {
        Input input = new Input();
        Output output = new Output();
        Parser parser = new Parser();
        calculator = new Calculator(input, output, parser);
    }
    
    public static void main(String[] args) {
        calculator.enter();
        calculator.plusAll();
        calculator.print();
        calculator.clear();
    }
}
