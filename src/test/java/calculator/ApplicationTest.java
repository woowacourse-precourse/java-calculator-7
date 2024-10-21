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
            // 구분자가 연속으로 주어지는 경우
            run("1::2::3");
            assertThat(output()).contains("결과 : 6");
            run(",,,,");
            assertThat(output()).contains("결과 : 0");
            // 커스텀 구분자와 기본 구분자를 혼용하는 경우
            run("//;\\n1,2:3;4");
            assertThat(output()).contains("결과 : 10");
            // 숫자를 커스텀 구분자로 사용하는 경우
            run("//1\\n21212");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_케이스() {
        assertSimpleTest(() -> {
                // 커스텀 구분자가 2글자 이상인 경우
                assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
                // 숫자로 0이 들어오는 경우
                assertThatThrownBy(() -> runException("0,1,2"))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
