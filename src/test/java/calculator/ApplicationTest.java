package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ApplicationTest extends NsTest {

    static Stream<Arguments> 기본_구분자_사용_TestCases() {
        return Stream.of(
                Arguments.of("1,2,3", "결과 : 6"),
                Arguments.of("1,2:3", "결과 : 6"),
                Arguments.of("1:2:3", "결과 : 6")
        );
    }

    @ParameterizedTest
    @MethodSource("기본_구분자_사용_TestCases")
    void 기본_구분자_사용(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }

    static Stream<Arguments> 커스텀_구분자_사용_TestCases() {
        return Stream.of(
                Arguments.of("//;\\n1", "결과 : 1"),
                Arguments.of("//@\\n1@2@3", "결과 : 6"),
                Arguments.of("//@\\n1@2,3", "결과 : 6"),
                Arguments.of("//@\\n1@2:3", "결과 : 6"),
                Arguments.of("//@\\n//@\\n1@2,3", "결과 : 6"),
                Arguments.of("//@\\n//;\\n1;2@3", "결과 : 6"),
                Arguments.of("//@\\n1@2@3", "결과 : 6")
        );
    }

    @ParameterizedTest
    @MethodSource("커스텀_구분자_사용_TestCases")
    void 커스텀_구분자_사용(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }

    static Stream<Arguments> 예외_테스트_TestCases() {
        return Stream.of(
                Arguments.of("-1,2,3"),
                Arguments.of("1,a,3"),
                Arguments.of("asdf"),
                Arguments.of("1@2@3"),
                Arguments.of("//@1@2@3"),
                Arguments.of("//@\\n//1,2,3")
        );
    }

    @ParameterizedTest
    @MethodSource("예외_테스트_TestCases")
    void 예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
