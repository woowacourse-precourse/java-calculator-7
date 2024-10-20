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
            run("//;\\n1;2;3");
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
    void 공백_입력_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3 "))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 커스텀_구분자_숫자_예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//2\\n122232"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 아무것도_입력_안했을떄() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    void 숫자만_입력했을때() {
        assertSimpleTest(() -> {
            run("7");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void BigInteger_테스트() {
        assertSimpleTest(() -> {
            run("9223372036854775808:1:2:3");
            assertThat(output()).contains("결과 : 9223372036854775814");
        });
    }

    @Test
    void BigInteger_테스트_커스텀_구분자() {
        assertSimpleTest(() -> {
            run("//!\\n9223372036854775808!1:2:3");
            assertThat(output()).contains("결과 : 9223372036854775814");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
