package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.dto.InputRequest;
import calculator.domain.dto.OutputResponse;
import calculator.domain.error.InputException;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorServiceTest {
    private CalculatorService calculatorService;

    @BeforeEach
    void set() {
        calculatorService = new CalculatorService();
    }

    @ParameterizedTest(name = "delimiters {0} | targetInput {1} expectedSumResult | {2}")
    @MethodSource("inputProvider")
    @DisplayName("다양한 구분자를 사용한 값 합계 테스트")
    public void testCalculateSum(String delimiters, String targetInput, int expectedSumResult) {
        InputRequest request = InputRequest.of(delimiters, targetInput);
        OutputResponse response = calculatorService.calculate(request);
        assertEquals(response.result(), expectedSumResult);
    }

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(",|:", "", 0), // 빈 문자열
                Arguments.of(",|:", "1", 1), // 기본 구분자
                Arguments.of(",|:", "1,2", 3),
                Arguments.of(",|:", "1,2:3", 6),
                Arguments.of(",|:|\\;", "1;2", 3), // 커스텀 구분자 - ;
                Arguments.of(",|:|\\ ", "1 2", 3), // 커스텀 구분자 - {공백}
                Arguments.of(",|:|\\?", "1?2", 3), // 커스텀 구분자 - ?
                Arguments.of(",|:|\\;;", "1;;2;;3", 6), // 커스텀 구분자 -;;
                Arguments.of(",|:|\\;;;;;", "1;;;;;2;;;;;3", 6), // 커스텀 구분자 - ;;;;;(5자)
                Arguments.of(",|:|\\;", "1,2:3;4", 10), // 커스텀 구분자
                Arguments.of(",|:|\\-", "1-2", 3) // 커스텀 구분자 - -
        );
    }

    @ParameterizedTest(name = "delimiters {0} | targetInput {1} ")
    @MethodSource("exceptionInputProvider")
    @DisplayName("잘못된 입력 값으로 예외 발생 테스트")
    public void testInvalidInputThrowsException(String delimiters, String targetInput) {
        InputRequest request = InputRequest.of(delimiters, targetInput);
        assertThrows(InputException.class, () ->
                calculatorService.calculate(request)
        );
    }

    static Stream<Arguments> exceptionInputProvider() {
        return Stream.of(
                Arguments.of(",|:", ";1;2"), // 첫 시작이 구분자
                Arguments.of(",|:", "1::::"), // 무분별한 구분자
                Arguments.of(",|:", "test"), // 양수가 아닌 문자
                Arguments.of(",|:", "1:-2:-2"), // 양수가 아닌 문자
                Arguments.of(",|:", "-1,2,3"),
                Arguments.of(",|:", "/1,2,3"), // 커스텀 구분자 조건 미충족
                Arguments.of(",|:", "!//!\\n1!1"),
                Arguments.of(",|:", "/;\\n1"),
                Arguments.of(",|:", "//;;1;;2;;3"), // \n 누락
                Arguments.of(",|:", "/n;\\n1"),
                Arguments.of(",|:", "//;n1"),
                Arguments.of(",|:", "//1\\n112"), // 구분자가 될 수 없는 정수형
                Arguments.of(",|:", "//!1!\\n11!1!2!1!"),
                Arguments.of(",|:", "//!!!!!!\\n1!!!!!!2"), // 1 ~ 5자를 초과한 구분자
                Arguments.of(",|:", "//\\n12"), // 커스텀 구분자 미입력
                Arguments.of(",|:", "                    ") //무분별한 공백
        );
    }

}