package calculator.controller;

import static calculator.common.constant.Constants.COLON;
import static calculator.common.constant.Constants.COMMA;

import calculator.model.Calculator;
import calculator.model.Operand;
import calculator.model.Separators;
import calculator.service.CustomSeparatorParser;
import calculator.service.OperandExtractor;
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
        String operationString = inputView.inputOperationString();
        CustomSeparatorParser parser = new CustomSeparatorParser(operationString);

        Separators separators = Separators.from(List.of(COMMA, COLON));

        if (parser.hasCustomSeparator()) {
            separators = separators.addSeparator(parser.extractSeparator());
            operationString = parser.stripCustomSeparator();
        }

        OperandExtractor operandExtractor = new OperandExtractor(separators);
        List<Operand> operands = operandExtractor.extractOperands(operationString);

        int result = Calculator.calculate(operands);
        outputView.printResult(result);
    }
}
