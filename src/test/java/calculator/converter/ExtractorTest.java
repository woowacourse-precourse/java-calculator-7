package calculator.converter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static calculator.utils.CalculatorConstants.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExtractorTest {

    @ParameterizedTest
    @MethodSource("providerDelimiterExtraction")
    void 구분자_추출_테스트(String value, String expectedDelimiter) {
        String delimiter = Extractor.extractDelimiter(value, DELIMITER_REGEX, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

        assertThat(delimiter).isEqualTo(expectedDelimiter);
    }

    @ParameterizedTest
    @MethodSource("providerNumberPartExtraction")
    void 숫자_추출_테스트(String value, String expectedNumberPart) {
        String numberPart = Extractor.extractNumberPart(value, CUSTOM_DELIMITER_PREFIX, CUSTOM_DELIMITER_SUFFIX);

        assertThat(numberPart).isEqualTo(expectedNumberPart);
    }

    static Stream<Arguments> providerDelimiterExtraction() {
        return Stream.of(
                Arguments.of("//+\\n1,2,3", "[,:+]"),
                Arguments.of("//_\\n1_2,3", "[,:_]"),
                Arguments.of("//;\\n1;2;3", "[,:;]")
        );
    }

    static Stream<Arguments> providerNumberPartExtraction() {
        return Stream.of(
                Arguments.of("//+\\n1,2,3", "1,2,3"),
                Arguments.of("//_\\n1", "1"),
                Arguments.of("//;\\n1;2;3", "1;2;3")
        );
    }

}
