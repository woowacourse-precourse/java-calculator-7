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
            run("//;\\n1;3");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 기본_구분자_커스텀_구분자_혼합_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 문자열_없이_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_지정_후_문자열_없이_입력() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_지정_문자_사용_커스텀_구분자_입력X() {
        assertSimpleTest(() -> {
            run("//\\n1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_지정_문자_사용_커스텀_구분자_입력X_연산_문자열_입력_X() {
        assertSimpleTest(() -> {
            run("//\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_연속_사용() {
        assertSimpleTest(() -> {
            run(",,,3,::5:");
            assertThat(output()).contains("결과 : 8");
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
}
