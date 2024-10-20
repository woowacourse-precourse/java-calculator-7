package calculator;

import calculator.view.StringReader;
import calculator.view.StringWriter;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        StringReader reader = new StringReader();
        DelimiterParser parser = new DelimiterParser();
        Adder adder = new Adder();

        String[] parsedInput = parser.parseFromInput(reader.read());
        int result = adder.add(parsedInput);

        StringWriter writer = new StringWriter();
        writer.write(result);

        Console.close();
    }
}
