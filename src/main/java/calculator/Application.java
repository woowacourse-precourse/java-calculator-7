package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        Calculator calculator = new Calculator();
        Extractor extractor = new Extractor();
        Separator separator = new Separator();

        Executor executor = new Executor(consoleIO, calculator, extractor, separator);
        executor.executeCalculator();
    }
}

