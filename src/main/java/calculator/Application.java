package calculator;

import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;

public class Application {

    public static void main(String[] args) {
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Splitter splitter = new Splitter();
        RegexGenerator regexGenerator = new RegexGenerator();
        NumberConverter numberConverter = new NumberConverter();
        IntegerAdder integerAdder = new IntegerAdder();

        StringCalculator stringCalculator = new StringCalculator(consoleInputHandler, consoleOutputHandler,
                delimiterExtractor, splitter, regexGenerator, numberConverter, integerAdder);

        Delimiters defaultDelimiters = stringCalculator.initialize();
        stringCalculator.run(defaultDelimiters);
    }

}
