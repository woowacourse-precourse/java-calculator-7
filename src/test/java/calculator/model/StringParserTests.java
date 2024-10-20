package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;

class StringParserTests {

    private Parser<Double> sample;

    @ParameterizedTest
    @DisplayName("입력한 표현식이 문법에 맞지 않으면 예외 발생")
    @CsvSource(value = {"1;2;3", "//\\n1:2:3", "//1\\n112131", "//.\\n1:2:3", "1;//;\\n2;3"})
    public void throwExceptionIfIncorrectGrammar(String input) {
        sample = new StringParser<>(input);
        assertThatThrownBy(() -> sample.parse(Double::parseDouble))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열을 실수형으로 파싱 가능")
    public void testIfNumberTypeDouble() {
        String input = "1.1:2:3";
        List<Double> expected = List.of(1.1, 2.0, 3.0);

        sample = new StringParser<>(input);

        List<Double> result = sample.parse(Double::parseDouble);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("여러 개의 커스텀 구분자를 사용할 때도 숫자 추출 가능")
    @CsvSource(value = {"//;*&\\n1*2&3;4", "//;*&\\n1&;2*3;&*4"})
    public void testIfUseManyCustomDelimiter(String input) {
        List<Double> expected = List.of(1.0, 2.0, 3.0, 4.0);

        sample = new StringParser<>(input);

        List<Double> result = sample.parse(Double::parseDouble);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @DisplayName("숫자 형식을 지키지 않은 경우 예외 발생")
    @CsvSource(value = {"1.:2.:3.", ".1:.2:.3"})
    public void testIfNumberFormatInvalid(String input) {
        sample = new StringParser<>(input);
        assertThatThrownBy(() -> sample.parse(Double::parseDouble))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("정규표현식의 예약문자를 커스텀 구분자로 사용하여 숫자 추출 가능")
    @MethodSource("provideStringToExpression")
    public void testIfUseMetaLetterAsDelimiter() {
        String input = "//[](){}.*+?^\\\\$\\|\\n1[2(3{4.5*6+7?8^9$10|11\\12";
        List<Double> expected = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0);

        sample = new StringParser<>(input);

        List<Double> result = sample.parse(Double::parseDouble);
        Assertions.assertEquals(expected, result);
    }
    private static Stream<Arguments> provideStringToExpression() {
        return Stream.of(
                Arguments.of("//[](){}.*+?^\\\\$\\|\\n1[2(3{4.5*6+7?8^9$10|11\\12"),
                Arguments.of("//[](){}*+?^\\\\$\\|\\n1.0[2.0(3.0{4.0\\5.0*6.0+7.0?8.0^9.0$10.0|11.0\\12.0")
        );
    }

    @ParameterizedTest
    @DisplayName("표현식이 빈 문자열인 경우 빈 리스트를 반환")
    @EmptySource
    public void testIfEmptyExpression(String input) {
        sample = new StringParser<>(input);

        List<Double> result = sample.parse(Double::parseDouble);
        Assertions.assertTrue(result.isEmpty());
    }
}