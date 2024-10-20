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
    void 기본_입력_테스트() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");

            assertThatThrownBy(() -> runException("-1:2.3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException(":1:2,3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("1::2,3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("1:-2,3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("0:2,3"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("1:2,n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_입력_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1:2;3");
            assertThat(output()).contains("결과 : 6");

            run("//;@#\\n1;2:3@4#5");
            assertThat(output()).contains("결과 : 15");

            assertThatThrownBy(() -> runException("//\\n1:2:3")).isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> runException("3//;\\n1;2:3")).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
