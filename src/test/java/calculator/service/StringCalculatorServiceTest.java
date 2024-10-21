package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StringCalculatorServiceTest {

    // 테스트 대상 객체 생성
    StringCalculatorService calculatorService = new StringCalculatorServiceImpl();

    @Test
    void add_빈문자열_테스트() {
        assertEquals(0, calculatorService.add("")); // 빈 문자열은 0을 반환해야 함
    }

    @Test
    void add_쉼표와_콜론_구분자_테스트() {
        assertEquals(6, calculatorService.add("1,2:3")); // 쉼표와 콜론을 구분자로 사용하는 경우
    }

    @Test
    void add_null_입력_테스트() {
        assertEquals(0, calculatorService.add(null)); // null 입력 시 0을 반환해야 함
    }

    @Test
    void add_단일숫자_테스트() {
        assertEquals(5, calculatorService.add("5")); // 단일 숫자는 그대로 반환
    }

    @Test
    void add_중복구분자_테스트() {
        assertEquals(6, calculatorService.add("1:2:3")); // 구분자가 중복되는 경우
    }

    @Test
    void add_커스텀_구분자_테스트_세미콜론() {
        assertEquals(6, calculatorService.add("//;\n1;2;3")); // 커스텀 구분자 세미콜론 처리
    }

    @Test
    void add_커스텀_구분자_테스트_파이프() {
        assertEquals(10, calculatorService.add("//|\n2|3|5")); // 커스텀 구분자 파이프 처리
    }

    @Test
    void add_기본_구분자와_커스텀_구분자_동시_테스트() {
        assertEquals(12, calculatorService.add("//;\n3;4:5")); // 기본 구분자와 커스텀 구분자를 동시에 사용하는 경우
    }
}
