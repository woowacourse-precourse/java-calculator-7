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
    void 커스텀_구분자_위치_테스트() {
        assertSimpleTest(() -> {
            run("12;3//;\\n");
            assertThat(output()).contains("커스텀 구분자는 문자열 처음에서만 추가할 수 있습니다.");
        });
    }

    @Test
    void 커스텀_구분자_개수_테스트() {
        assertSimpleTest(() -> {
            run("//!@;\\n");
            assertThat(output()).contains("한개의 커스텀 구분자만 추가할 수 있습니다.");
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
