package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    /*
        ---------------------------------------------------------------
        my test
    */

    @Test
    @DisplayName("커스텀 문자열 사이 특수기호가 아닌 경우 예외 처리")
    void exceptionTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//a\\n1a2a3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });

        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//2\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 문자열 사이, 2글자 이상 오는 경우 예외 처리")
    void exceptionMoreThan2Char() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//**\\n1a2a3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 문자열 사이, 아무 문자도 들어오지 않는 경우 예외 처리")
    void exceptionEmptyChar() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("커스텀 구분자 추가시, 표현식이 이상한 경우")
    void exceptionWrongExpression() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("/\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\nnqq"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void sampleTest() {
        assertSimpleTest(() -> run(""));
        assertThat(output()).contains("결과 : 0");
        assertSimpleTest(() -> run("1,2"));
        assertThat(output()).contains("결과 : 3");
        assertSimpleTest(() -> run("1,2,3"));
        assertThat(output()).contains("결과 : 6");
        assertSimpleTest(() -> run("1,2:3"));
        assertThat(output()).contains("결과 : 6");
    }

    @Test
    @DisplayName("10의 자리 연산 테스트")
    void calcTest() {
        String input1 = "//+\\n1+2+3+4+5+6+7+8+9+10";
        assertSimpleTest(() -> run(input1));
        assertThat(output()).contains("결과 : 55");
        String input2 = "//+\\n10+20+30+40";
        assertSimpleTest(() -> run(input2));
        assertThat(output()).contains("결과 : 100");
    }
}
