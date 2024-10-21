package calculator.controller;

import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    /**
     * @param calculatorRequestDto 계산할 입력 문자열을 담고 있는 데이터 전송 객체
     * @return 계산 결과를 포함하는 데이터 전송 객체
     */
    private CalculatorResponseDto calculator(CalculatorRequestDto calculatorRequestDto) {
        final String result = calculatorService.calculate(calculatorRequestDto.input());

        return new CalculatorResponseDto(result);
    }

    /**
     * 사용자에게 입력을 받고, 계산 결과를 출력하는 애플리케이션의 실행을 시작합니다.
     */
    public void run() {
        CalculatorRequestDto calculatorRequestDto = InputView.beginInput();
        OutputView.printResult(calculator(calculatorRequestDto).result());
    }

}
