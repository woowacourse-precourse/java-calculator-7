package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.dto.CalculatorRequestDto;

/**
 * packageName    : calculator
 * fileName       : Application
 * author         : ehgur062300
 * date           : 2024-10-18
 * description    : mvc로 패턴으로 리팩토링 해보기
 * ===========================================================
 * DATE              AUTHOR                 NOTE
 * -----------------------------------------------------------
 * 2024-10-18      ehgur062300           version 1.1
 */

public class Application {

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController();

        // 애플리케이션 실행
        calculatorController.run();

        // 클라이언트가 request(문자열) 보냄
        CalculatorRequestDto requestDto = calculatorController.inputFormula();

        // request(문자열) 유효성 검사
        calculatorController.validateInput(requestDto);

        // 수식 계산하기
        int result = calculatorController.calculateFormula(requestDto);

        // 결과 출력
        calculatorController.printResult(result);
    }


}