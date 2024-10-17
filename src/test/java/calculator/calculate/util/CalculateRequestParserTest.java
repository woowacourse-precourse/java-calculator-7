package calculator.calculate.util;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculateRequestParserTest {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");

    @ParameterizedTest
    @MethodSource("validParsingSource")
    void 유효한_파싱(String parseTarget, List<Integer> expectedParsedNumbers) {
        Assertions.assertThat(CalculateRequestParser.parsingRequest(parseTarget, DEFAULT_DELIMITERS))
                .containsExactly(expectedParsedNumbers.toArray(new Integer[0]));
    }

    private static Stream<Arguments> validParsingSource() {
        return Stream.of(
                Arguments.of("1:4:3", List.of(1,4,3)),
                Arguments.of("2,81:9", List.of(2,81,9)),
                Arguments.of("//@\\n1@4:3", List.of(1,4,3))
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"//////1:4:3", "//\\n2,81:9"})
    void 유효하지_않은_파싱(String parseTarget) {
        Assertions.assertThatThrownBy(() -> CalculateRequestParser.parsingRequest(parseTarget, DEFAULT_DELIMITERS))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}