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

    public CalculateController(InputView inputView,
                               OutputView outputView,
                               OperandParser operandParser,
                               DelimiterParser separatorParser,
                               Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.operandParser = operandParser;
        this.delimiterParser = separatorParser;
        this.calculator = calculator;
    }

    public void calculate() {

        outputView.printStartString();
        String inputString = inputView.getInputString();
        DelimiterParserResult delimParserResult = delimiterParser.parsingDelimiters(inputString);
        List<String> operands = operandParser.parsingOperands(delimParserResult);
        int result = calculator.sum(operands);
        outputView.printResult(result);
    }
}
