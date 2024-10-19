package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @CsvSource({
            "'//@\\n1', 1",
            "'//#\\n1#2', 3",
            "'//aa\\n1aa2aa3', 6",
            "'// \\n1 2 3', 6",
            "'//ㅁ\\n1ㅁ2ㅁ3', 6",
    })
    void 여러_커스텀_구분자_사용(String input, long expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @ParameterizedTest(name = "입력값: {0}, 기대값: {1}")
    @CsvSource({
            "'\n', 0",
            "'1', 1",
            "'1,', 1",
            "'1,2', 3",
            "'1:2,', 3",
            "'1,2:3', 6",
            "'1,2:3:', 6",
    })
    void 기본_구분자_사용(String input, long expected) {
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
            "//;\\n1.2;2;3",
            "//;\\n-1;2;3",
            "//;\\n1; ;3",
            "//;\\n1;2,3",
            "//\\n1,2,3"
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
            "1.2,2,3",
            "-1,2:3",
            "1, :3",
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
}
