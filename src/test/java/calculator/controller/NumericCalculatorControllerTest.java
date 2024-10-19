package calculator.controller;

import calculator.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연산자 작동 테스트")
class NumericCalculatorControllerTest {
    private NumericCalculatorController numericCalculatorController;

    @BeforeEach
    void setUp() {
        numericCalculatorController = new NumericCalculatorController();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4","1:2:3"})
    @DisplayName("기본 연산자를 사용한 데이터 객체를 받아서 연산부분 객체를 생성한다")
    void createCalculatorWithDefaultDelimiter(String input) {
        InputData inputData = new InputData(input);
        Delimiter delimiter = new DefaultDelimiter();
        assertThat(numericCalculatorController.createCalculatorPart(delimiter, inputData))
                .isInstanceOf(Arithmetic.class);
    }

    private static Stream<List<String>> customDelimiterData() {
        return Stream.of(
                List.of("//;\\n1;2;3", ";"),
                List.of("//!\\n1!2!3", "!"),
                List.of("//a\\n1a2a3", "a")
        );
    }

    @ParameterizedTest
    @MethodSource("customDelimiterData")
    @DisplayName("커스텀 연산자를 사용한 데이터 객체를 받아서 연산부분 객체를 생성한다")
    void createCalculatorWithCustomDelimiter(List<String> input) {
        InputData inputData = new InputData(input.get(0));
        Delimiter delimiter = new CustomDelimiter(input.get(1));
        assertThat(numericCalculatorController.createCalculatorPart(delimiter, inputData))
                .isInstanceOf(Arithmetic.class);
    }
}