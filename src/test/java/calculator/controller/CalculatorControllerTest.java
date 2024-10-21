package calculator.controller;

import calculator.model.Calculator;
import calculator.service.NumbersService;
import calculator.service.SeparatorsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CalculatorController 테스트")
class CalculatorControllerTest {
    private CalculatorController calculatorController;

    @BeforeEach
    void setUp() {
        calculatorController = new CalculatorController(new SeparatorsService(),
                new NumbersService(),
                new Calculator());
    } // setUp

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("구분자를 포함하고 있는지 확인")
    @MethodSource("generateSeparatorData")
    void testContainsSeparators(String input, boolean output, String message) {
        assertThat(calculatorController.containsSeparator(input)).isEqualTo(output);
    } // testContainsSeparators

    static Stream<Arguments> generateSeparatorData() {
        return Stream.of(
                Arguments.of("//!@\\n1!2@3", true, "커스텀 구분자 포함"),
                Arguments.of("1,2:3", true, "기본 구분자 포함"),
                Arguments.of("123", false, "구분자 미포함")
        );
    } // generateSeparatorData
} // class