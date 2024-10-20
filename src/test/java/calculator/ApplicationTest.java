package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 일반() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("1,2,4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 기본_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("1,2:4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 기본_구분자_사용_3() {
        assertSimpleTest(() -> {
            run("1:2:4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 커스텀_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//;\\n1;3;2");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n-1|2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n-1|2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n-1|2|3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n1,2|3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n1:2|3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_10() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n1::2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_11() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n1: :2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_12() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n9|8|7|"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_13() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&\\n&3&4&5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
