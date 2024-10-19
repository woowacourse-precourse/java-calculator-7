package calculator.service;

import calculator.model.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("NumbersService 테스트")
class NumbersServiceTest {
    private NumbersService numbersService;

    @BeforeEach
    void setUp() {
        numbersService = new NumbersService();
    } // setUp

    @Test
    @DisplayName("구분자로 구분 후 Numbers 객체 생성 확인")
    void testCreateNumbersWithSeparators() {
        assertThat(numbersService.createNumbers(List.of(1, 2, 3))).isInstanceOf(Numbers.class);
    } // testCreateNumbersWithSeparators

    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("구분자가 없을 때 Numbers 객체 생성 확인")
    @MethodSource("generateData")
    void testCreateNumbersNotWithSeparators(String input, Class output, String message) {
        assertThat(numbersService.createNumbers(input)).isInstanceOf(output);
    } // testCreateNumbersNotWithSeparators

    private static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(null, Numbers.class, "null 입력"),
                Arguments.of("", Numbers.class, "공백 입력"),
                Arguments.of(" ", Numbers.class, "white space 입력"),
                Arguments.of("1", Numbers.class, "숫자 1만 입력")
        );
    } // generateData

    @ParameterizedTest(name = "{index} : {1}")
    @DisplayName("Numbers 객체 생성 예외 확인")
    @MethodSource("generateExceptionData")
    void inputExceptionTest(String input, String message) {
        assertThatThrownBy(() -> numbersService.createNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    } // inputExceptionTest

    private static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(";123", "숫자만으로 구성되지 않았을 때"),
                Arguments.of("-2", "음수일 때")
        );
    } // generateExceptionData
} // class