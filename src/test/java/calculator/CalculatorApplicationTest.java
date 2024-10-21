package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorApplicationTest extends NsTest {

    @Test
    void 빈입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀구분자없는_정상적인입력() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀구분자있는_정상적인입력() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자없는_잘못된입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀구분자있는_잘못된입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n-1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
