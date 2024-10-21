package calculator;

import static calculator.DelimiterGenerator.generateDelimiterInputDTO;
import static calculator.NumberExtractor.sumParsedNumbers;
import static calculator.OutputWriter.writeOutput;
import static calculator.UserInputReader.readInput;

public class Calculator {
    public void calculate() {

        String input = readInput();
        DelimiterInputDTO delimiterInputDTO = generateDelimiterInputDTO(input);
        Long sum = sumParsedNumbers(delimiterInputDTO.getInput(), delimiterInputDTO.getDelimiter());

        writeOutput(sum);
    }
}
