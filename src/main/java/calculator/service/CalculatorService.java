package calculator.service;

import calculator.model.Operand;
import calculator.util.OperandConverter;
import calculator.util.StringParser;

import java.util.List;

public class CalculatorService {

    public int calculateSum(String input) {

        List<String> parsedStrings = StringParser.parseInput(input);
        List<Operand> operands = OperandConverter.convertToOperands(parsedStrings);

        return operands.stream().mapToInt(Operand::number).sum();

    }

}
