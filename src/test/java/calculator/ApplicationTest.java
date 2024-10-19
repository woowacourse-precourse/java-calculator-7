package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 구분자_없이_숫자() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//*\\n32,1:2*9");
            assertThat(output()).contains("결과 : 44");
        });
    }

    @Test
    void 커스텀_구분자_사용_3() {
        assertSimpleTest(() -> {
            run("///*-\\n32,1:2*9/56-7");
            assertThat(output()).contains("결과 : 107");
        });
    }

    @Test
    void 커스텀_구분자_사용_4() {
        assertSimpleTest(() -> {
            run("///\\*46-\\n32,1:2*9/565-7\\30");
            assertThat(output()).contains("결과 : 91");
        });
    }

    @Test
    void 예외_테스트_음수입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_잘못된_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_입력_오류_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_입력_오류_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_잘못된_구분자_사용_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1$2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
