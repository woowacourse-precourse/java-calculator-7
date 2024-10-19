package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("클라이언트 입력이 공백 일 때")
    void isEmptyInput() {
        // Given
        String userInput = " ";

        // When
        boolean result = calculatorService.isBlank(userInput);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("클라이언트 입력이 길이가 0인 문자열일 때")
    void isBlankInput() {
        // Given
        String userInput = "";

        // When
        boolean result = calculatorService.isBlank(userInput);

        // Then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3', ''",
            "'//k\\n1;2;3k4', 'k'"
    })
    @DisplayName("커스텀 구분자 추출 테스트")
    void parseCustomSeparator(String input, String customSeparator) {
        // Given & When
        String result = calculatorService.parseCustomSeparator(input);

        // Then
        assertThat(result).isEqualTo(customSeparator);
    }

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedAndCustomSeparator")
    void splitBySeparatorTest(String input, String[] expected, String customSeparator) {

        // Given & When
        String[] strings = calculatorService.splitBySeparator(input, customSeparator);
        // Then
        assertThat(strings).isEqualTo(expected);
    }

    static Stream<Object[]> provideInputAndExpectedAndCustomSeparator() {
        return Stream.of(
                new Object[]{"1:2:3k4", new String[]{"1", "2", "3", "4"}, "k"},
                new Object[]{"5;6:7", new String[]{"5", "6", "7"}, ";"},
                new Object[]{"8,9,10", new String[]{"8", "9", "10"}, "o"},
                new Object[]{"11.12.13", new String[]{"11", "12", "13"}, "."},
                new Object[]{"14,1:5,1,6", new String[]{"14", "1", "5", "1", "6"}, ""}
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputNumbersAndExpected")
    @DisplayName("더하기 계산결과 테스트")
    void calculateTest(String[] inputNumbers, long expected) {

        // Given & Then
        long result = calculatorService.calculate(inputNumbers);
        // Then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Object[]> provideInputNumbersAndExpected() {
        return Stream.of(
                new Object[]{new String[]{"1", "2", "3", "4"}, 10},
                new Object[]{new String[]{"5", "6", "7"}, 18},
                new Object[]{new String[]{"8", "9", "10"}, 27},
                new Object[]{new String[]{"11", "12", "13"}, 36},
                new Object[]{new String[]{"14", "1", "5", "1", "6"}, 27}
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3', 6",
            "'//;\\n1', 1",
            "'//;\\n1:2', 3",
            "'//;\\n', 0",
    })
    @DisplayName("메인 로직 테스트")
    void checkLogic(String userInput, long expected) {

        // Given & When
        long answer = calculatorService.logic(userInput);

        // Then
        assertThat(answer).isEqualTo(expected);
    }
}