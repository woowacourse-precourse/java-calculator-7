package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.CalculateService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();

    private static Stream<Arguments> provideDefaultDelimiterInputSuccess() {
        return Stream.of(
                Arguments.of(List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.TEN), BigDecimal.valueOf(13)),
                Arguments.of(List.of(), BigDecimal.valueOf(0)),
                Arguments.of(List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.valueOf(10000000000L)),
                        BigDecimal.valueOf(10000000003L))
        );
    }

    @ParameterizedTest
    @MethodSource("provideDefaultDelimiterInputSuccess")
    public void 숫자들의_합_계산(List<BigDecimal> numbers, BigDecimal expected) {
        BigDecimal actual = calculateService.sum(numbers);
        assertEquals(expected, actual);
    }
}
