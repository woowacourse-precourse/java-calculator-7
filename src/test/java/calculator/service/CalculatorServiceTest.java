package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void 기본구분자_더하기_테스트() {
        int add = calculatorService.calculator("1:2,3");
        assertEquals(6, add);
    }

    @Test
    void 커스텀구분자_더하기_테스트() {
        int add = calculatorService.calculator("//;\\n1;2;3");
        assertEquals(6, add);
    }

    @Test
    @DisplayName("빈 값이 입력될 경우 Exception 발생")
    void 빈값_입력될_경우() {
        Assertions.assertThatThrownBy(() -> calculatorService.calculator(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 값이 없습니다");
    }

    @Test
    @DisplayName("입력된 문자열에 숫자가 없을 경우 Exception 발생")
    void 입력문자열_숫자가_존재하지않을경우() {
        Assertions.assertThatThrownBy(() -> calculatorService.calculator(":,:,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자열에 숫자가 존재하지 않습니다");
    }

    @Test
    @DisplayName("커스텀 구분자 뒤에 '\\' 를 붙이지 않으면 Exception 발생.")
    void 커스텀구분자_더하기_예외_테스트1() {
        Assertions.assertThatThrownBy(() -> calculatorService.calculator("//;\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력된 문자열에 숫자가 존재하지 않습니다");
    }

    @Test
    @DisplayName("구분자로 분리한 후 음수가 존재하는 경우 Exception 발생")
    void CalculatorServiceTest() {
        Assertions.assertThatThrownBy(() -> calculatorService.calculator("-1:2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수가 아닌 음수가 존재 합니다. 프로그램을 종료합니다");
    }


}