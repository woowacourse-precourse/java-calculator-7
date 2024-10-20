package calculator;

import java.util.List;

public class Calculator {
    private final Parser parser;
    private final Reader reader;
    private final Writer writer;

    public Calculator(Parser parser, Reader reader, Writer writer) {
        this.parser = parser;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        String input = reader.readInput();

        Character delimiter = parser.parseCustomDelimiter(input);
        List<Integer> integers = parser.parsePositiveIntegers(input, delimiter);

        writer.writeOutput(sum(integers));
    }

    private Integer sum(List<Integer> integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }
}
