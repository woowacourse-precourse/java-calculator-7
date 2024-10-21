package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringParser;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringParserTest {
    StringParser stringParser = new StringParser();

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
    public void 기본_구분자로_문자열_분리(String input, List<BigDecimal> expected) {
        List<BigDecimal> numbers = stringParser.parse(input);
        assertEquals(expected, numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,-2,10", "1/2/10", "1,2,a,10", "1,,2,10"})
    public void 입력에_잘못된_값이_포함된_경우_에러_발생(String input) {
        assertThrows(IllegalArgumentException.class, ()
                -> stringParser.parse(input));
    }
}
