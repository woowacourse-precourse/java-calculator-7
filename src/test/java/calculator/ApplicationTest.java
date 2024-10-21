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
    void 단일_숫자_테스트() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 여러_구분자_혼합_사용_테스트() {
        assertSimpleTest(() -> {
            run("1,2;3,4;5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 잘못된_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 값을 입력했습니다: a")
        );
    }

    @Test
    void 여러_음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 허용되지 않습니다.: -1, -2")
        );
    }

    @Test
    void 커스텀_구분자_여러_숫자_테스트() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
