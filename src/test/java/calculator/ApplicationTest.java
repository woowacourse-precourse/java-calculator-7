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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//3\\n132");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 여러_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//$$$\\n13$$$2");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_디폴트_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//$\\n1$3:2,3");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 소수_테스트() {
        assertSimpleTest(() -> {
            run("//$\\n1$3.95343");
            assertThat(output()).contains("결과 : 4.95343");
        });
    }

    @Test
    void 숫자만_입력_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 공백만_입력_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_없음_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n1$3.95343"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_공백_테스트() {
        assertSimpleTest(() -> {
            run("// \\n1 3.95343");
            assertThat(output()).contains("결과 : 4.95343");
        });
    }

    @Test
    void 커스텀_구분자_양식틀림_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\n1,3.95343"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
