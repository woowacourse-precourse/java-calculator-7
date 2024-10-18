package calculator.controller;

import calculator.model.Calculator;
import calculator.model.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연산자 작동 테스트")
class NumericCalculatorControllerTest {
    private NumericCalculatorController numericCalculatorController;

    @BeforeEach
    void setUp() {
        numericCalculatorController = new NumericCalculatorController();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4","//;\\n1;2;3"})
    @DisplayName("데이터 객체를 받아서 계산기 객체를 생성한다")
    void createCalculator(String input) {
        InputData inputData = new InputData(input);
        assertThat(numericCalculatorController.createCalculatorPart(inputData))
                .isInstanceOf(Calculator.class);
    }
}