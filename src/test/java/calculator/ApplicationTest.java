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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 빈_값_입력_테스트() {
        assertSimpleTest(() -> {
            run ("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 여러_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//_\\n1;2_3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러_커스텀_구분자_그룹_사용() {
        assertSimpleTest(() -> {
            run("//;\\n//_$\\n//^\\n1,2:3;4_5$6^7");
            assertThat(output()).contains("결과 : 28");
        });
    }

    @Test
    void 예외_테스트_사용할_수_없는_구분자_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//-\\n//+\\n//*/\\n1-3+4"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("사용할 수 없는 구분자입니다.");
        });
    }

    @Test
    void 예외_테스트_올바르지_않은_입력값_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1:2,a:5"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("올바르지 않은 입력값입니다.");
        });
    }

    @Test
    void 예외_테스트_양수가_아닌_숫자_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자는 1 이상의 양수만 입력 가능합니다.");
        });
    }

}
