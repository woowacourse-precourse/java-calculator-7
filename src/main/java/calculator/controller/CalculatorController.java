package calculator.controller;

import calculator.dto.OperandDTO;
import calculator.dto.ResultDTO;
import calculator.dto.UserInputDTO;
import calculator.service.CalculateService;
import calculator.service.ParsingService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public static void run(){
        UserInputDTO userInputDTO = getUserInput();

        //문자열 입력 처리
        String operandStr = userInputDTO.getOperandStr();

        //문자열 파싱 처리
        OperandDTO operandDTO = parseOperand(operandStr);

        //덧셈연산계산
        ResultDTO resultDTO = addOperand(operandDTO);

        OutputView.printCalculationResultMessage(resultDTO);
    }

    public static UserInputDTO getUserInput(){
        OutputView.printRequireOperandStringMessage();
        return InputView.getOperandInput();
    }

    public static OperandDTO parseOperand(String operandStr){
        return ParsingService.parseOperandStr(operandStr);
    }

    public static ResultDTO addOperand(OperandDTO operandDTO){
        return CalculateService.addOperand(operandDTO);
    }
}
