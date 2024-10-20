package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    static Stream<Arguments> provideWithCustomDelimiterInput() {
        return Stream.of(
                Arguments.of("//;\\n1;2;3", 6),
                Arguments.of("//.\\n1.2:3", 6),
                Arguments.of("//;\\n1;2;3;4;5", 15),
                Arguments.of("//.\\n1.2:3:4:5", 15),
                Arguments.of("//a\\n", 0)
        );
    }

    static Stream<Arguments> provideWithoutCustomDelimiterInput() {
        return Stream.of(
                Arguments.of("1,2,3", 6),
                Arguments.of("1,2:3,4", 10),
                Arguments.of("1,2:3:4,5", 15),
                Arguments.of("\n", 0)
        );
    }

    @ParameterizedTest(name = "입력: {0}, 기대값: {1}")
    @MethodSource("provideWithCustomDelimiterInput")
    void 커스텀_구분자_사용(String input, int expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @ParameterizedTest(name = "입력: {0}, 기대값: {1}")
    @MethodSource("provideWithoutCustomDelimiterInput")
    void 커스텀_구분자_미사용(String input, int expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
