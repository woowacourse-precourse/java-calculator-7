package calculator.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputSplitterTest {

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideInputWithDefaultDelimiter")
    void 기본_구분자로_구분된_입력(String input, String[] expected, int size) {
        // given
        InputSplitter inputSplitter = new InputSplitter();

        // when
        String[] splitInputs = inputSplitter.split(input);

        // then
        assertThat(splitInputs).hasSize(size);
        assertThat(splitInputs).containsExactly(expected);
    }

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideInputWithCustomDelimiter")
    void 커스텀_구분자로_구분된_입력(String input, String[] expected, int size) {
        // given
        InputSplitter inputSplitter = new InputSplitter();

        // when
        String[] splitInputs = inputSplitter.split(input);

        // then
        assertThat(splitInputs).hasSize(size);
        assertThat(splitInputs).containsExactly(expected);
    }

    static Stream<Arguments> provideInputWithDefaultDelimiter() {
        return Stream.of(
                Arguments.of("1", new String[]{"1"}, 1),
                Arguments.of("1,2", new String[]{"1", "2"}, 2),
                Arguments.of("1:2", new String[]{"1", "2"}, 2),
                Arguments.of("1,2,3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("2:3:4", new String[]{"2", "3", "4"}, 3),
                Arguments.of("1,2:3:4", new String[]{"1", "2", "3", "4"}, 4),
                Arguments.of("1:2:3,4", new String[]{"1", "2", "3", "4"}, 4)
        );
    }

    static Stream<Arguments> provideInputWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\\n1", new String[]{"1"}, 1),
                Arguments.of("//!\\n1!2", new String[]{"1", "2"}, 2),
                Arguments.of("//@\\n1@2@3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("//asd\\n1asd2asd3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("//0\\n10203", new String[]{"1", "2", "3"}, 3),
                Arguments.of("// \\n1 2 3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("//\b\\n1\b2\b3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("//\n\\n1\n2\n3", new String[]{"1", "2", "3"}, 3),
                Arguments.of("//,\\n1,2,3", new String[]{"1", "2", "3"}, 3)
        );
    }
}