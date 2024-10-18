package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

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
    void 정상_케이스() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
            run("1::2::3");
            assertThat(output()).contains("결과 : 6");
            run("1,2,3:4:5");
            assertThat(output()).contains("결과 : 15");
            run("//1\\n21212");
            assertThat(output()).contains("결과 : 6");
            run(",,,,3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 예외_케이스() {
        assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
                assertThatThrownBy(() -> runException("//;\\n1,2:3"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
