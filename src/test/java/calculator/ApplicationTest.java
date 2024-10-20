package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_이스케이프_문자() {
        assertSimpleTest(() -> {
            run("//\\\\t\\n1\\\\t4");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 커스텀_구분자_사용_메타_문자() {
        assertSimpleTest(() -> {
            run("//[\\n1[2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 양의_실수_계산() {
        assertSimpleTest(() -> {
            run("0.1,1.9");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_형식() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
