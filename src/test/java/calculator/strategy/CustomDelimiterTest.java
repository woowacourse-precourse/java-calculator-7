package calculator.strategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CustomDelimiterTest {

    @ParameterizedTest(name = "구분자: {0}, 입력값: {1}, 기대값: {2}")
    @MethodSource("provideCustomDelimiter")
    void 커스텀_구분자_사용(String delimiter, String input, String[] expected) {
        // given
        CustomDelimiter customDelimiter = new CustomDelimiter(delimiter);

        // when
        String[] result = customDelimiter.split(input);

        // then
        assertThat(result).hasSize(expected.length);
        assertThat(result).containsExactly(expected);
    }

    static Stream<Arguments> provideCustomDelimiter() {
        return Stream.of(
                Arguments.of("!", "1", new String[]{"1"}),
                Arguments.of("!", "1!2", new String[]{"1", "2"}),
                Arguments.of("@", "1@2", new String[]{"1", "2"}),
                Arguments.of("#", "1#2#3", new String[]{"1", "2", "3"}),
                Arguments.of("a", "1a2a3", new String[]{"1", "2", "3"}),
                Arguments.of("0", "10203", new String[]{"1", "2", "3"}),
                Arguments.of("0", "1020300", new String[]{"1", "2", "3"}),
                Arguments.of("a123", "1a1232a1233", new String[]{"1", "2", "3"})
        );
    }
}