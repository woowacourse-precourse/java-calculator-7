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
    void 예외_테스트_음수_입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_등록되지_않은_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_올바르지_않은_입력_형식1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_올바르지_않은_입력_형식2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\|n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열_중간에서_커스텀_구분자_등록(){
        assertSimpleTest(() -> {
            run("1,2:3//;\\n4;5;6//@\\n7@8");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
