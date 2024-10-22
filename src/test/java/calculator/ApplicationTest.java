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
    void 커스텀_구분자_미사용() {
        assertSimpleTest( ()->
                run("2,3:4"));
                assertThat(output()).contains("결과 : 9");
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값_공백() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자로끝남() {
        assertSimpleTest(() -> {
            run("2,3");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 구분자_없는_입력값() {
        assertSimpleTest(() -> {
            run("2345");
            assertThat(output()).contains("결과 : 2345");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
