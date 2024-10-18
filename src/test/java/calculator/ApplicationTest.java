package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 기본_구분자_쉼표와_콜론() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_마이너스() {
        assertSimpleTest(() -> {
            run("//-\\n1-2-3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 잘못된_구분자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2:3;4"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 연속된_구분자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,,2::3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_숫자_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//1\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test   
    void 커스텀_구분자_문자_시작_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//-\\n-1,2-3"))
                .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
