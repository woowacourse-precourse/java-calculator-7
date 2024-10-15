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
    void 실수_테스트() {
        assertSimpleTest(() -> {
            run("1.2;1.3,1"); // 실수도 계산 가능
            assertThat(output()).contains("결과 : 3.5");
        });
    }

    @Test
    void 커스텀_구분자_숫자() {
        assertSimpleTest(() -> {
            run("//1\\n21312"); // 1을 구분자로 판단
            assertThat(output()).contains("결과 : 7");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
