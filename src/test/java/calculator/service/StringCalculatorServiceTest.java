package calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.validator.InputValidator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringCalculatorServiceTest {

    private StringCalculatorService calculator;

    @BeforeEach
    void setUp() {
        InputValidator inputValidator = new InputValidator();
        StringSplitterService stringSplitter = new StringSplitterService();
        calculator = new StringCalculatorService(inputValidator, stringSplitter);
    }

    @DisplayName("빈 문자열 입력 테스트")
    @ParameterizedTest(name = "{index} 빈 문자열 결과는 0")
    @MethodSource("emptyStringTestProvider")
    void checkEmptyStringInput(String input, Integer expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

    @DisplayName("정상적인 문자열 입력 테스트")
    @ParameterizedTest(name = "{index} 정규 입력 {0}")
    @MethodSource("normalStringTestProvider")
    void checkNormalStringInput(String input, Integer expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

    @DisplayName("잘못된 형식 문자열 입력 테스트")
    @ParameterizedTest(name = "{index} 잘못된 형식 예외 발생 테스트 {0}")
    @MethodSource("invalidFormatTestProvider")
    void checkInvalidFormatInput(String input, Class<? extends Exception> expectedException) {
        assertThrows(expectedException, () -> calculator.calculate(input));
    }

    @DisplayName("커스텀 구분자 뒤에 숫자가 없는 경우 테스트")
    @ParameterizedTest(name = "{index} 구분자 뒤에 숫자가 없는 경우 예외 발생")
    @MethodSource("missingNumberAfterCustomDelimiterTestProvider")
    void checkMissingNumberAfterDelimiter(String input, Class<? extends Exception> expectedException) {
        assertThrows(expectedException, () -> calculator.calculate(input));
    }

    static List<Arguments> emptyStringTestProvider() {
        return List.of(
                Arguments.arguments("", 0),
                Arguments.arguments("1,,2", 3, null),
                Arguments.arguments(" ", 0)
        );
    }

    static List<Arguments> normalStringTestProvider() {
        return List.of(
                Arguments.arguments("1,2,3", 6),
                Arguments.arguments("//abc\\n1abc2abc3", 6),
                Arguments.arguments("//@\\n1@2@3", 6)
        );
    }

    static List<Arguments> invalidFormatTestProvider() {
        return List.of(Arguments.arguments("1," + "9".repeat(1000), IllegalArgumentException.class),
                // "abc"는 하나의 구분자로 취급되지만, "a"는 개별 구분자로 사용할 수 없으므로 예외 발생
                Arguments.arguments("//abc\\n1a2a3", IllegalArgumentException.class));
    }

    static List<Arguments> missingNumberAfterCustomDelimiterTestProvider() {
        return List.of(
                // 커스텀 구분자를 설정하였지만 숫자가 없는 경우 예외가 발생
                Arguments.arguments("//abc\n", IllegalArgumentException.class)
        );
    }
}