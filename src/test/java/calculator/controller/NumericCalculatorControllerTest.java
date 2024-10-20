package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.model.Arithmetic;
import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.InputData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

@DisplayName("연산자 작동 테스트")
class NumericCalculatorControllerTest {
    private NumericCalculatorController numericCalculatorController;

    @BeforeEach
    void setUp() {
        numericCalculatorController = new NumericCalculatorController();
    }

    private static Stream<Arguments> delimiterData() {
        return Stream.of(
                Arguments.of(new InputData("//;\\n1;2;3"), new CustomDelimiter(";"), "[;] 커스텀 구분자"),
                Arguments.of(new InputData("//!\\n1!2!3"), new CustomDelimiter("!"), "[!] 커스텀 구분자"),
                Arguments.of(new InputData("//a\\n1a2a3"), new CustomDelimiter("a"), "[a] 커스텀 구분자"),
                Arguments.of(new InputData("//;a\\n1;2a3"), new CustomDelimiter(";a"), "[;a] 커스텀 구분자"),
                Arguments.of(new InputData("1,2,3,4"), new DefaultDelimiter(), "[,] 기본 구분자"),
                Arguments.of(new InputData("1:2:3"), new DefaultDelimiter(), "[:] 기본 구분자"),
                Arguments.of(new InputData("1:2:3,4,5"), new DefaultDelimiter(), "[,:] 기본 구분자")
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("delimiterData")
    @DisplayName("데이터 객체를 받아서 연산부분 객체를 생성한다")
    void createArithmeticWithDelimiter(InputData inputData,Delimiter delimiter, String testCase) {
        assertThat(numericCalculatorController.createCalculatorPart(delimiter, inputData))
                .isInstanceOf(Arithmetic.class);
    }
}