package calculator.controller;

import static calculator.common.constant.Constants.COLON;
import static calculator.common.constant.Constants.COMMA;
import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_PREFIX;
import static calculator.common.constant.Constants.CUSTOM_SEPARATOR_SUFFIX;
import static calculator.common.constant.Constants.SEPARATOR_SIZE;

import calculator.common.util.CustomSeparatorParser;
import calculator.common.util.OperandExtractor;
import calculator.model.Calculator;
import calculator.model.Operand;
import calculator.model.Separators;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class StringCalculator {

    private final InputView inputView;
    private final OutputView outputView;

    public StringCalculator(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Separators separators = Separators.from(List.of(COMMA, COLON));

        String operationString = inputView.inputOperationString();

        if (CustomSeparatorParser.hasCustomSeparator(operationString)) {
            separators = separators.addSeparator(CustomSeparatorParser.extractSeparator(operationString));
            operationString = stripCustomSeparator(operationString);
        }

        OperandExtractor operandExtractor = new OperandExtractor(separators);
        List<Operand> operands = operandExtractor.extractOperands(operationString);

        int result = Calculator.calculate(operands);
        outputView.printResult(result);
    }

    private String stripCustomSeparator(String operationString) {
        return operationString.substring(
                CUSTOM_SEPARATOR_PREFIX.length() + SEPARATOR_SIZE + CUSTOM_SEPARATOR_SUFFIX.length());
    }
}
