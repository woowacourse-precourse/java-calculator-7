package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 특수_구분자_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//~\\n-1~2~3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 특수_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//~~\\n-1~~2~~3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
