package calculator;

public class AppInitializer {

    public Executor initialize() {

        ConsoleIO consoleIO = new ConsoleIO();
        Calculator calculator = new Calculator();
        Extractor extractor = new Extractor();
        Separator separator = new Separator();

        return new Executor(consoleIO, calculator, extractor, separator);
    }

}
