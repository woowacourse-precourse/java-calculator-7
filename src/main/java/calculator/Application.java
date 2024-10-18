package calculator;

import calculator.adder.IntegerAdder;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.util.DelimiterExtractor;
import calculator.util.NumberConverter;
import calculator.util.RegexGenerator;
import calculator.util.Splitter;
import delimiter.Delimiters;

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
