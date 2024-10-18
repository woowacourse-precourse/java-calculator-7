package calculator.service;

import static org.assertj.core.api.Assertions.*;

import calculator.domain.exception.CalculatorErrorMessage;
import calculator.domain.exception.CalculatorException;
import calculator.dto.request.CalculatorRequest;
import calculator.dto.response.CalculatorResponse;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorServiceImplTest {
    private CalculatorServiceImpl calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    @DisplayName("정상적인 요청에 대한 계산 결과가 올바르게 반환되어야 한다.")
    void testCalculateSumValidRequest(String delimiters, String targetInput, int expectedSum) {
        CalculatorRequest request = CalculatorRequest.of(delimiters, targetInput);

        CalculatorResponse response = calculatorService.calculateSum(request);

        assertThat(response.result()).isEqualTo(expectedSum);
    }

    static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(",|:", "1,2:3", 6),             // 기본 구분자와 정상적인 입력
                Arguments.of(",|:", "", 0),                  // 빈 입력에 대한 테스트
                Arguments.of(",|:|\\^", "1^2:3,4", 10)       // 커스텀 구분자를 포함한 정상적인 입력
        );
    }

    @ParameterizedTest
    @MethodSource("invalidInputProvider")
    @DisplayName("잘못된 입력에 대해 IllegalArgumentException이 발생해야 한다.")
    void testCalculateSumInvalidInput(String delimiters, String targetInput) {
        CalculatorRequest request = CalculatorRequest.of(delimiters, targetInput);

        assertThatThrownBy(() -> calculatorService.calculateSum(request))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining(CalculatorErrorMessage.NOT_NUMBER_ERROR.getMessage());
    }

    static Stream<Arguments> invalidInputProvider() {
        return Stream.of(
                Arguments.of(",|:", "n"),        // 문자 입력
                Arguments.of(",|:", "1,n,3"),    // 숫자 중간에 문자 포함
                Arguments.of(",|:", "1,2,,3"),   // 연속된 구분자
                Arguments.of(",|:", ",1,2"),     // 앞에 구분자가 있는 경우
                Arguments.of(",|:", "1,2,"),     // 마지막에 구분자가 있는 경우
                Arguments.of(",|:", "1,2,:")    // 음수 입력
        );
    }

    @Test
    @DisplayName("음수가 포함된 입력에 대해 IllegalArgumentException이 발생해야 한다.")
    void testIncludeMinusTest() {
        String delimiters = ",|:";
        String targetInput = "-1,2,3";
        CalculatorRequest request = CalculatorRequest.of(delimiters, targetInput);

        assertThatThrownBy(() -> calculatorService.calculateSum(request))
                .isInstanceOf(CalculatorException.class)
                .hasMessageContaining(CalculatorErrorMessage.INVALID_RANGE_ERROR.getMessage());
    }
}