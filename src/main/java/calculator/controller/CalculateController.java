package calculator.controller;


import calculator.domain.Calculator;
import calculator.domain.dto.DelimiterParserResult;
import calculator.domain.service.DelimiterParser;
import calculator.domain.service.OperandParser;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;


public class CalculateController {

    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterParser delimiterParser;
    private final OperandParser operandParser;
    private final Calculator calculator;

    public CalculateController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.operandParser = new OperandParser();
        this.delimiterParser = new DelimiterParser();
        this.calculator = new Calculator();
    }

    public void calculate() {

        outputView.printStartString();
        String inputString = inputView.getInputString();
        if (inputString == null || inputString.isEmpty()) {
            outputView.printResult(0);
        } else {
            DelimiterParserResult delimParserResult = delimiterParser.parsingDelimiters(inputString);
            List<String> operands = operandParser.parsingOperands(delimParserResult);
            int result = calculator.sum(operands);
            outputView.printResult(result);
        }

    }
}
