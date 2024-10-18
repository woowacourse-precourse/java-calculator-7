package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });

        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_0_포함하여_입력() {
        assertSimpleTest(() -> {
            run("0,2:3");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 여러_자리_숫자_입력() {
        assertSimpleTest(() -> {
            run("10,20:30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
