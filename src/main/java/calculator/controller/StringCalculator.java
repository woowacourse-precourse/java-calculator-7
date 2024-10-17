package calculator.controller;

import static calculator.common.constant.Constants.COLON;
import static calculator.common.constant.Constants.COMMA;
import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_PREFIX;
import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_SUFFIX;
import static calculator.common.constant.Constants.SEPARATOR_SIZE;

import calculator.common.util.CustomSeparatorParser;
import calculator.common.util.OperandExtractor;
import calculator.model.Operand;
import calculator.model.Separators;
import calculator.view.InputView;
import java.util.List;

public class StringCalculator {

    private final InputView inputView;

    public StringCalculator(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Separators separators = Separators.from(List.of(COMMA, COLON));

        String operationString = inputView.inputOperationString();

        if (CustomSeparatorParser.hasCustomSeparator(operationString)) {
            separators.addSeparator(CustomSeparatorParser.extractSeparator(operationString));
            operationString = stripCustomSeparator(operationString);
        }

        OperandExtractor operandExtractor = new OperandExtractor(separators);
        List<Operand> operands = operandExtractor.extractOperands(operationString);

    }

    private String stripCustomSeparator(String operationString) {
        return operationString.substring(
                CUSTOM_SEPARATOR_PREFIX.length() + SEPARATOR_SIZE + CUSTOM_SEPARATOR_SUFFIX.length());
    }
}
