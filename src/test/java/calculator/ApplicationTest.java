package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용_semicolon만() {
        assertSimpleTest(() -> {
            run("1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자_사용_comma만() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용_혼용사용() {
        assertSimpleTest(() -> {
            run("2,3;4");
            assertThat(output()).contains("결과 : 9");
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
    void 큰_수_입력_테스트() {
        assertSimpleTest(() -> {
            run("10000000000000000000;10000000");
            assertThat(output()).contains("결과 : 10000000000010000000");
        });
    }

    @Test
    void 음수입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_형식오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구문자_위치오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구문자_중복사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
