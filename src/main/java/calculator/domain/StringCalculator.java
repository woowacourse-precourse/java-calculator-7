package calculator.domain;

import calculator.service.CalculatorService;

/**
 * StringCalculator 클래스 :  문자열 형태의 수식을 계산하는 계산기를 구현, CalculatorService를 사용하여 실제 계산을 수행함
 */
public class StringCalculator {
    private final CalculatorService service;

    /**
     * StringCalculator의 새 인스턴스를 생성, CalculatorService 인스턴스를 초기화
     */
    public StringCalculator() {
        this.service = new CalculatorService();
    }

    /**
     * 문자열 입력을 계산하는 로직
     *
     * @param input 계산할 수식을 나타내는 문자열
     * @return 계산 결과를 나타내는 Number 객체
     * @throws IllegalArgumentException 입력이 유효하지 않은 경우 (예: 음수, 잘못된 형식 등) , 기존 로깅이 있었지만 현재 가독성을 위해 삭제, 추후 필요성을 위해 구조 남겨둠
     */
    public Number calculate(String input) {
        try {
            return service.calculate(input);
        } catch (IllegalArgumentException e) {
            // 추후 예외처리를 위하여 구조 유지
            throw e;
        }
    }
}