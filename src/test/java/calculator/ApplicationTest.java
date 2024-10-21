package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 여러_구분자_사용() {
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
    void 구분자가_없는_경우() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_동시_사용한_경우() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트_숫자가_아닌_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,a"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수가_있는_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_prefix만_입력한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_suffix만_입력한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(";\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_prefix를_입력한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1//;\\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_잘못된_suffix를_입력한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\ n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_빈_문자열을_입력한_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
