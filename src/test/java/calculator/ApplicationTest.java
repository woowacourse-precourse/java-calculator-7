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
    void 커스텀_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//*&^\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_미선언_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1.2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수_입력값_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException((Integer.MAX_VALUE)+"123;"+(Integer.MAX_VALUE)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
