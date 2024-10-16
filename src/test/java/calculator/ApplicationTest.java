package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("커스텀 구분자 한개, 숫자 한개일 때")
    void useCustomSplit() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("음수가 포함됐을 때")
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test()
    @DisplayName("커스텀 구분자가 2글자 이상일 때")
    void splitLengthTest() {
        assertSimpleTest(() -> {
            run("//;;;\\n1;;;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("입력값 마지막에 구분자가 있을 때")
    void lastCharIsSeperator() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3-"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("int 범위를 넘어가는 수를 입력받았을 때")
    void beyondInteger() {
        assertSimpleTest(() -> {
            run("//;\\n2147483648;2147483648");
            assertThat(output()).contains("결과 : 4294967296");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
