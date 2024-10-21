package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringParser;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {
    StringParser stringParser;

    @BeforeEach
    public void setUp() {
        stringParser = new StringParser();
    }

    private static Stream<Arguments> provideDefaultDelimiterInputSuccess() {
        return Stream.of(
                Arguments.of("1,2,10", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.TEN)),
                Arguments.of("1:2:10", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.TEN)),
                Arguments.of("1,2:10", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.TEN)),
                Arguments.of("1,2,10000000000", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(
                        10000000000L)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideDefaultDelimiterInputSuccess")
    void 기본_구분자로_문자열을_분리한다(String input, List<BigDecimal> expected) {
        List<BigDecimal> numbers = stringParser.parse(input);
        assertEquals(expected, numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2,10", "1/2/10", "1,2,a,10", "1,,2,10"})
    void 잘못된_값이_포함된_경우_IllegalArgumentException_발생(String input) {
        assertThrows(IllegalArgumentException.class, ()
                -> stringParser.parse(input));
    }


    private static Stream<Arguments> provideCustomDelimiterInput() {
        return Stream.of(
                Arguments.of("//;\\n1;2;3", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3))),
                Arguments.of("//.\\n1.2.3", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3))),
                Arguments.of("//a\\n1a2a3", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3))),
                Arguments.of("//**\\n1**2**3", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3))),
                Arguments.of("//[**]\\n1[**]2[**]3", List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCustomDelimiterInput")
    void 커스텀_구분자로_문자열을_분리한다(String input, List<BigDecimal> expected) {
        List<BigDecimal> numbers = stringParser.parse(input);
        assertEquals(expected, numbers);
    }

    @Test
    void 커스텀_구분자와_기본_구분자가_혼합된_경우에도_문자열을_ㅆ리한다() {
        String input = "//;\\n1;2:3,4";
        List<BigDecimal> expected = List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(3),
                BigDecimal.valueOf(4));

        List<BigDecimal> numbers = stringParser.parse(input);
        assertEquals(expected, numbers);
    }

    private static Stream<Arguments> provideWrongCustomDelimiterInput() {
        return Stream.of(
                Arguments.of("//;1;2;3;4",
                        List.of(BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4))),
                Arguments.of("//|\\n1|2,3:4",
                        List.of(BigDecimal.ONE, BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4)))
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"//;1;2;3;4", "//|\\n1;2;3;4", "//;\\n1;2,,3"})
    void 잘못된_커스텀_구분자_형식일_경우_IllegalArgumentException_발생(String input) {
        assertThrows(IllegalArgumentException.class, ()
                -> stringParser.parse(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\n"})
    void 빈_문자열_입력_시_BigDecimal_0을_반환한다(String input) {
        List<BigDecimal> expected = List.of(BigDecimal.ZERO);
        List<BigDecimal> numbers = stringParser.parse(input);
        assertEquals(expected, numbers);
    }

}
