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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 마이너스_구분자_사용() {
        assertSimpleTest(() -> {
            run("//-\\n1,2:3-4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트_마이너스_구분자와_음수_사용() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-\\n1,2:3--4"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_숫자_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1,2:+"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_커스텀_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
