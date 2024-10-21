package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 디폴트_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀과_디폴트_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈문자열_사용() {
        assertSimpleTest(() -> {
            run("3,,");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 여러_자리의_숫자_사용() {
        assertSimpleTest(() -> {
            run("100,20,30");
            assertThat(output()).contains("결과 : 150");
        });
    }

    @DisplayName("음수 입력")
    @Test
    void 예외_테스트_1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자가 아닌 입력")
    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("올바르지 않은 커스텀 구분자 입력")
    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("비어있는 커스텀 구분자 입력")
    @Test
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
