package calculator;

import static calculator.DelimiterGenerator.generateDelimiterInputDTO;
import static calculator.NumberExtractor.parseInput;
import static calculator.OutputWriter.writeOutput;
import static calculator.UserInputReader.readInput;

import java.util.List;

public class Calculator {
    public void calculate() {

        String input = readInput();
        DelimiterInputDTO delimiterInputDTO = generateDelimiterInputDTO(input);
        List<Long> parsedInput = parseInput(delimiterInputDTO.getInput(), delimiterInputDTO.getDelimiter());

        Long sum = parsedInput.stream().reduce(0L, Long::sum);

        writeOutput(sum);
    }
}
