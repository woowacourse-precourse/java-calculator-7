package calculator.controller;

import calculator.dto.OperandDTO;
import calculator.dto.ResultDTO;
import calculator.service.CalculateService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static final ParsingService parsingService = new ParsingService();
    private static final CalculateService calculateService = new CalculateService();

    public static void run(){
        OutputView.printRequireOperandStringMessage();
        String operandStr = InputView.getOperandInput();

        OperandDTO operandDTO = parsingService.parseOperandStr(operandStr);
        ResultDTO resultDTO = CalculateService.addOperand(operandDTO);

        OutputView.printCalculationResultMessage(resultDTO);
    }
}
