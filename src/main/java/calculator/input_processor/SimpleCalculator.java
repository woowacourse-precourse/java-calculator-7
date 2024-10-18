package calculator.input_processor;

import java.util.List;

public class SimpleCalculator {
    private final OperandExtractor operandExtractor;
    private final OperandConverter operandConverter;
    private final OperandProcessor operandProcessor;
    public SimpleCalculator(OperandExtractor operandExtractor, OperandConverter operandConverter,OperandProcessor operandProcessor) {
        this.operandExtractor = operandExtractor;
        this.operandConverter = operandConverter;
        this.operandProcessor = operandProcessor;
    }

    public int run(String input) {
        String[] extractedOperands = operandExtractor.extractOperand(input);
        List<Integer> convertedOperands = operandConverter.convertOperandToInt(extractedOperands);
        return operandProcessor.add(convertedOperands);
    }
}
