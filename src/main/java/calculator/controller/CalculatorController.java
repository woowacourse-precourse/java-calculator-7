package calculator.controller;

import calculator.dto.OperandDTO;
import calculator.dto.ResultDTO;
import calculator.dto.UserInputDTO;
import calculator.service.CalculateService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private static final ParsingService parsingService = new ParsingService();
    private static final CalculateService calculateService = new CalculateService();

    public static void run(){
        UserInputDTO userInputDTO = getUserInput();

        String operandStr = userInputDTO.getOperandStr();
        OperandDTO operandDTO = parseOperand(operandStr);
        ResultDTO resultDTO = addOperand(operandDTO);

        OutputView.printCalculationResultMessage(resultDTO);
    }

    //문자열 입력 처리
    public static UserInputDTO getUserInput(){
        OutputView.printRequireOperandStringMessage();
        return InputView.getOperandInput();
    }

    //문자열 파싱 처리
    public static OperandDTO parseOperand(String operandStr){
        return parsingService.parseOperandStr(operandStr);
    }

    //덧셈연산계산
    public static ResultDTO addOperand(OperandDTO operandDTO){
        return CalculateService.addOperand(operandDTO);
    }
}
