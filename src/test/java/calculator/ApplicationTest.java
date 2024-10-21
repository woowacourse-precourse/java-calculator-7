package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_온점() {
        assertSimpleTest(() -> {
            run("//.\\n1.3.1:2");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 정수만_입력() {
        assertSimpleTest(() -> {
            run("1,2,3:4");
            assertThat(output()).contains("결과 : 10.0");
        });
    }

    @Test
    void 소수_정수_섞어서_입력() {
        assertSimpleTest(() -> {
            run("1.3:2,3.1:5.7");
            assertThat(output()).contains("결과 : 12.1");
        });
    }

    @Test
    void 소수_입력() {
        assertSimpleTest(() -> {
            run("1.2,1.3,1.7:8");
            assertThat(output()).contains("결과 : 12.2");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
