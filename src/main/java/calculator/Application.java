package calculator;

import calculator.adapter.Console;
import calculator.adapter.Convertor;
import calculator.adapter.MessageInputAdapter;
import calculator.adapter.MessageOutputAdapter;
import calculator.application.DelimiterParser;
import calculator.application.DelimiterValidator;
import calculator.domain.Plus;

public class Application {

    public static void main(String[] args) {
        final var console = new Console(new MessageInputAdapter(), new MessageOutputAdapter());

        final var convertor = new Convertor();
        final var delimiterValidator = new DelimiterValidator();
        final var delimiterParser = new DelimiterParser(delimiterValidator);

        final var plus = new Plus();

        var inputString = console.readString();

        final var delimiterList = delimiterParser.parseToDelimiterList(inputString);
        final var parsed = delimiterParser.getParsed();
        final var numberList = convertor.convertToNumberList(parsed, delimiterList);

        final var result = plus.execute(numberList);

        console.printResult(result);
    }
}