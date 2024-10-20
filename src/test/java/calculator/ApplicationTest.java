package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 두_자릿수_숫자_포함() {
        assertSimpleTest(() -> {
            run("12,2;63");
            assertThat(output()).contains("결과 : 77");
        });
    }

    @Test
    void 음수_문자열_포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_커스텀_구분자_등록() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//-\\n1-2;3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 등록되지_않는_구분자_사용() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1'2,3;4"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
