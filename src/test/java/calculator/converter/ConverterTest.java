package calculator.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static calculator.utils.CalculatorConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    Converter converter = new Converter(DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

    @ParameterizedTest
    @MethodSource("provideNumbersForDefaultDelimiter")
    void 기본_구분자로_숫자_분리(String value, List<Integer> expectNumbers) {
        List<Integer> numbers = converter.convertNumbersFromString(value);
        assertThat(numbers).isEqualTo(expectNumbers);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForCustomDelimiter")
    void 커스텀_구분자로_숫자_분리(String value, List<Integer> expectNumbers) {
        List<Integer> numbers = converter.convertNumbersFromString(value);
        assertThat(numbers).isEqualTo(expectNumbers);
    }

    static Stream<Arguments> provideNumbersForDefaultDelimiter() {
        return Stream.of(
                Arguments.of("1,2:3", List.of(1, 2, 3)),
                Arguments.of("1", List.of(1)),
                Arguments.of("1:2:3", List.of(1, 2, 3))
        );
    }

    static Stream<Arguments> provideNumbersForCustomDelimiter() {
        return Stream.of(
                Arguments.of("//_\\n1_2,3", List.of(1, 2, 3)),
                Arguments.of("//+\\n1+2,3", List.of(1, 2, 3)),
                Arguments.of("//|\\n1,2|3", List.of(1, 2, 3))
        );
    }

}
