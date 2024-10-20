package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideNumbersWithCustomDelimiter")
    void 여러_커스텀_구분자_사용(String input, Number expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @MethodSource("provideNumbersWithDefaultDelimiter")
    void 기본_구분자_사용(String input, Number expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {
            "//;\\n",
            "//;\\na",
            "//;\\n1;2;a",
            "//;\\n-1;2;3",
            "//;\\n1; ;3",
            "//;\\n1;2,3",
            "//\\n1,2,3",
            "//;\\n1;",
            "//;\\n1;2;",
            "//;\\n1;;;",
            "//;\\n;",
    })
    void 예외_테스트_커스텀_구분자(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(strings = {
            "a",
            "1,2,a",
            "-1,2:3",
            "1, :3",
            "1,",
            "1,2,",
            "1,,,",
            ",",
    })
    void 예외_테스트_기본_구분자(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    static Stream<Arguments> provideNumbersWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\\n1", 1L),
                Arguments.of("//;\\n1.0", 1L),
                Arguments.of("//!\\n1!2", 3L),
                Arguments.of("//@\\n1@2@3", 6L),
                Arguments.of("//asd\\n1asd2asd3", 6L),
                Arguments.of("//0\\n10203", 6L),
                Arguments.of("// \\n1 2 3", 6L),
                Arguments.of("//\b\\n1\b2\b3", 6L),
                Arguments.of("//,\\n1,2,3", 6L),
                Arguments.of("//;\\n1.2;2.3;3.4", 6.9),
                Arguments.of("//.\\n1.2.3", 6L),
                Arguments.of("//..\\n1..2..3", 6L)
        );
    }

    static Stream<Arguments> provideNumbersWithDefaultDelimiter() {
        return Stream.of(
                Arguments.of("\n", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1:2", 3),
                Arguments.of("1,2:3", 6),
                Arguments.of("1:2,3", 6),
                Arguments.of("1.2:2.3,3.4", 6.9)
        );
    }
}
