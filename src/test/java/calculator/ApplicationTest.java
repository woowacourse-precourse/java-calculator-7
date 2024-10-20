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
    void 커스텀_구분자와_기본_구분자_혼용_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1,2;3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 값");
        });
    }

    @Test
    void 여러_커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//[;][&]\\n1;2&3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
