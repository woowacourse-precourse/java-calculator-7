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
    void 기본_구문자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,-3:5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 비정상_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2:3.e"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 비정상_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2;3:1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_혼합_사용_테스트() {
        assertSimpleTest(() -> {
            run("//'\\n1:3'5,2");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
