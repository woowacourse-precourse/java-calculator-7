package calculator;

import calculator.domain.Numbers;
import calculator.parser.DelimiterParser;
import calculator.view.StringReader;
import calculator.view.StringWriter;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        StringReader reader = new StringReader();
        DelimiterParser parser = new DelimiterParser();
        StringWriter writer = new StringWriter();

        String[] parsedInput = parser.parseFromInput(reader.read());
        Numbers numbers = new Numbers(parsedInput);

        writer.write(numbers.add());

        Console.close();
    }
}
