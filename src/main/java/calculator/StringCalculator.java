package calculator;

import calculator.domain.adder.Addable;
import calculator.domain.delimiter.Delimiter;
import calculator.domain.delimiter.DelimiterExtractor;
import calculator.domain.delimiter.Delimiters;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.util.converter.NumberConvertible;
import calculator.util.splitter.Splitter;
import java.util.List;

public class StringCalculator {

    private final ConsoleInputHandler consoleInputHandler;
    private final ConsoleOutputHandler consoleOutputHandler;
    private final DelimiterExtractor delimiterExtractor;
    private final Splitter splitter;
    private final NumberConvertible numberConvertible;
    private final Addable addable;

    public StringCalculator(ConsoleInputHandler consoleInputHandler, ConsoleOutputHandler consoleOutputHandler,
                            DelimiterExtractor delimiterExtractor, Splitter splitter,
                            NumberConvertible numberConvertible, Addable addable) {
        this.consoleInputHandler = consoleInputHandler;
        this.consoleOutputHandler = consoleOutputHandler;
        this.delimiterExtractor = delimiterExtractor;
        this.splitter = splitter;
        this.numberConvertible = numberConvertible;
        this.addable = addable;
    }

    public Delimiters initialize() {

        return new Delimiters(List.of(new Delimiter(","), new Delimiter(":")));
    }

    public void run(final Delimiters defaultDelimiters) {
        String input = consoleInputHandler.getUserInput();

        Delimiters delimiters = delimiterExtractor.extractDelimitersFrom(input, defaultDelimiters);

        List<String> splitInput = splitter.splitByDelimiters(input, delimiters);

        List numbers = numberConvertible.convertStringToNumber(splitInput);

        consoleOutputHandler.printResult(addable.addNumbers(numbers));
    }

}
