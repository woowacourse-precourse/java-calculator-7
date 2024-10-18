package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용1() {
        assertSimpleTest(() -> {
            run("1,2:3,4,5:6:7");
            assertThat(output()).contains("결과 : 28");
        });
    }

    @Test
    void 기본_구분자_사용_0출력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3-4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_0출력() {
        assertSimpleTest(() -> {
            run("//-\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구문자_예외_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구문자_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구문자_예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1;2-3-4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
