package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 기본_구분자를_사용() {
        assertSimpleTest(() -> {
            run("10,20:30");
            assertThat(output()).contains("결과 : 60");
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
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_커스텀_구분자_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-n1-2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속된_구분자_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1::2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자_사용_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1:2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_아닌_문자_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
