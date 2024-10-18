package calculator.strategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DefaultDelimiterTest {

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideDefaultDelimiter")
    void 기본_구분자_사용(String input, String[] expected) {
        // given
        DefaultDelimiter delimiter = new DefaultDelimiter();

        // when
        String[] result = delimiter.split(input);

        // then
        assertThat(result).hasSize(expected.length);
        assertThat(result).containsExactly(expected);
    }

    static Stream<Arguments> provideDefaultDelimiter() {
        return Stream.of(
                Arguments.of("1", new String[]{"1"}),
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1:2", new String[]{"1", "2"}),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}),
                Arguments.of("2:3:4", new String[]{"2", "3", "4"}),
                Arguments.of("1,2:3:4", new String[]{"1", "2", "3", "4"}),
                Arguments.of("1:2:3,4", new String[]{"1", "2", "3", "4"})
        );
    }
}