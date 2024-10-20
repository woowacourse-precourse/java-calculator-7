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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_입력_예외() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수값_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("//;\n1;-2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자에_이스케이프__문자() {
        assertSimpleTest(() -> {
            run("//\\\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
