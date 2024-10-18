package calculator;

import calculator.adder.Addable;
import calculator.converter.NumberConvertible;
import calculator.io.ConsoleInputHandler;
import calculator.io.ConsoleOutputHandler;
import calculator.regex.RegexGenerator;
import calculator.util.DelimiterExtractor;
import calculator.util.Splitter;
import delimiter.Delimiter;
import delimiter.Delimiters;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final ConsoleInputHandler consoleInputHandler;
    private final ConsoleOutputHandler consoleOutputHandler;
    private final DelimiterExtractor delimiterExtractor;
    private final Splitter splitter;
    private final RegexGenerator regexGenerator;
    private final NumberConvertible numberConvertible;
    private final Addable addable;

    public StringCalculator(ConsoleInputHandler consoleInputHandler, ConsoleOutputHandler consoleOutputHandler,
                            DelimiterExtractor delimiterExtractor, Splitter splitter,
                            RegexGenerator regexGenerator, NumberConvertible numberConvertible,
                            Addable addable) {
        this.consoleInputHandler = consoleInputHandler;
        this.consoleOutputHandler = consoleOutputHandler;
        this.delimiterExtractor = delimiterExtractor;
        this.splitter = splitter;
        this.regexGenerator = regexGenerator;
        this.numberConvertible = numberConvertible;
        this.addable = addable;
    }

    public Delimiters initialize() {
        Delimiter commaDelimiter = new Delimiter(",");
        Delimiter colonDelimiter = new Delimiter(":");

        return new Delimiters(Arrays.asList(commaDelimiter, colonDelimiter));
    }

    public void run(Delimiters defaultDelimiters) {
        // 0. 입력한다.
        String input = consoleInputHandler.getUserInput();

        // 1.커스텀 구분자를 추출하여 저장한다.
        defaultDelimiters = defaultDelimiters.merge(delimiterExtractor.extractCustomDelimiter(input));

        //2. 구분자를 기준으로 문자열을 추출한다.
        String[] splitedInput = splitter.splitedByDelimiters(input, defaultDelimiters, regexGenerator);

        //3. 추출한 문자열을 숫자로 변환한다.
        List<Number> numbers = numberConvertible.convertStringToNumber(splitedInput);

        // 4. 구한 숫자들을 더한 값을 출력한다.
        consoleOutputHandler.printResult(addable.addNumbers(numbers));
    }

}
