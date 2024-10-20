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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//x\\n1x2x3");
            assertThat(output()).contains("결과 : 6");
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
    void 기본_구분자_혼합_사용_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_문자열_시작_오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_입력값_포함시_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;a;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_숫자입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
