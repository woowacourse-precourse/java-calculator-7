package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @DisplayName("커스텀 구분자가 없는 경우")
    @Test()
    void executeAdd() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("1,2:3");
        // then
        assertEquals(6, answer);
    }

    @DisplayName("커스텀 구분자가 있는 경우")
    @Test()
    void executeAddWithCustomSeparator() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("//;\\n1;2;3");
        // then
        assertEquals(6, answer);
    }

    @DisplayName("커스텀 구분자가 있는 경우2")
    @Test()
    void executeAddWithCustomSeparator2() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("//^\\n1^2^3");
        // then
        assertEquals(6, answer);
    }

    @DisplayName("커스텀 구분자가 띄어쓰기인 경우")
    @Test()
    void executeAddWithCustomSeparatorWithBlank() {
        // given
        // when
        Integer answer = calculatorService.executeAdd("// \\n1 2 3");
        // then
        assertEquals(6, answer);
    }

    @DisplayName("커스텀 구분자가 공백인 경우")
    @Test()
    void executeAddWithCustomSeparatorWithBlank2() {
        // given
        // when
        assertThatThrownBy(() -> calculatorService.executeAdd("//\\n123"))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @DisplayName("커스텀 구분자가 없는 경우")
    @Test()
    void executeAddWithCustomSeparatorWithBlank3() {
        // given
        // when
        assertThatThrownBy(() -> calculatorService.executeAdd("//\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }


}