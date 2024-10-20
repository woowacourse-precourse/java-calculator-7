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
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 예외_테스트_음수() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자가_아닌_경우() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3,a"))
                .isInstanceOf(NumberFormatException.class)
        );
    }

    @Test
    void 구분자_분리_실패_END_문자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_분리_실패_START_문자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(";\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 한글자_문자열() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 구분자_위치_오류() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1//;\\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈문자열_오류() {
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
