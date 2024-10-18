package calculator;

import calculator.adder.Addable;
import calculator.adder.IntegerAdder;
import calculator.converter.IntegerConvertible;
import calculator.converter.NumberConvertible;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.regex.RegexGenerator;
import calculator.util.DelimiterExtractor;
import calculator.util.Splitter;
import delimiter.Delimiters;

public class Application {

    public static void main(String[] args) {
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
        ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        Splitter splitter = new Splitter();
        RegexGenerator regexGenerator = new RegexGenerator();
        NumberConvertible numberConvertible = new IntegerConvertible();
        Addable adder = new IntegerAdder();

        StringCalculator stringCalculator = new StringCalculator(consoleInputHandler, consoleOutputHandler,
                delimiterExtractor, splitter, regexGenerator, numberConvertible, adder);

        Delimiters defaultDelimiters = stringCalculator.initialize();
        stringCalculator.run(defaultDelimiters);
    }

}
