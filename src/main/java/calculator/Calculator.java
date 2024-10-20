package calculator;

import static calculator.DelimiterGenerator.generateDelimiter;
import static calculator.NumberExtractor.parseInput;
import static calculator.UserInputReader.readInput;

import java.util.List;

public class Calculator {
    public void calculate() {

        String input = readInput();
        DelimiterInputDTO delimiter = generateDelimiter(input);
        List<Long> parsedInput = parseInput(delimiter);

        Long sum = parsedInput.stream().reduce(0L, Long::sum);
    }
}
