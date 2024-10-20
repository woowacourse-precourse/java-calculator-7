package calculator;

import static calculator.DelimiterGenerator.generateDelimiterInputDTO;
import static calculator.NumberExtractor.parseInput;
import static calculator.OutputWriter.writeOutput;
import static calculator.UserInputReader.readInput;

import java.util.List;

public class Calculator {
    public void calculate() {

        String input = readInput();
        DelimiterInputDTO delimiter = generateDelimiterInputDTO(input);
        List<Long> parsedInput = parseInput(delimiter);

        Long sum = parsedInput.stream().reduce(0L, Long::sum);

        writeOutput(sum);
    }
}
