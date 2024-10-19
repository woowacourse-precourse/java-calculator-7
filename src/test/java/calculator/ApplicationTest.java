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
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러_자리수_사용() {
        assertSimpleTest(() -> {
            run("10,100:1000");
            assertThat(output()).contains("결과 : 1110");
        });
    }

    @Test
    void 기본_구분자_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",1:2"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 기본_구분자_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:2:"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 다른_구분자_사용_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3.4"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 공백_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("// \\n1 3");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 다른_커스텀_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\\\n1,2;3?4"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 아무_입력_없음() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_입력_없음() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 숫자_입력_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
