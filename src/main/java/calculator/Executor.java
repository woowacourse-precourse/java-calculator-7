package calculator;

public class Executor {

    private final ConsoleIO consoleIO;
    private final Separator separator;
    private final Extractor extractor;
    private final Calculator calculator;

    public Executor(ConsoleIO consoleIO, Calculator calculator, Extractor extractor, Separator separator) {
        this.consoleIO = consoleIO;
        this.calculator = calculator;
        this.extractor = extractor;
        this.separator = separator;
    }

    public void executeCalculator() {
        String inputStr = consoleIO.readInput();

        String separators = separator.getSeparator(inputStr);
        String numbers = extractor.extractNumbers(inputStr);

        long answer = calculator.addNumbers(numbers, separators);

        consoleIO.printOutput(answer);
    }

}
