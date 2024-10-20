package calculator.service;

import calculator.controller.calculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class addOperationTest {
    @DisplayName("커스텀 구분자로 실행에 성공한다.")
    @Test
    void 커스텀_구분자__성공() {
        String input = "//;\\n1;2;3";
        int expectedSum = 6;

        addOperation calculator = new addOperation();
        int result = calculator.add(input);

        assertEquals(result, expectedSum);
    }

    @DisplayName("기본 구분자와 커스텀 구분자가 함께 있을 때 실행에 성공한다.")
    @Test
    void 기본_구분자_커스텀_구분자_성공() {
        String input = "//;\\n1,2;3:4";
        int expectedSum = 10;

        addOperation calculator = new addOperation();
        int result = calculator.add(input);

        assertEquals(result, expectedSum);
    }

}