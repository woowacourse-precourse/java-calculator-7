package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//b\\n1b2b3", "//b\\n1b2,3", "//b\\n1:2b3"})
    void 커스텀_구분자_사용2(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 공백을_입력하면_0으로_간주한다(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 0");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//b\\n1b b3", "//b\\n1bb3"})
    void 공백을_입력하면_0으로_간주한다2(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,0,3", "/a\n1a2a3"})
    void 예외_테스트2(String input) {
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
