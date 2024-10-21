package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Application 통합 테스트")
class ApplicationTest extends NsTest {
    @Test
    @DisplayName("[성공] - 커스텀 구분자 사용 X")
    void success_NoSeparator() {
        assertSimpleTest(() -> {
            run("1,2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("[성공] - 커스텀 구분자 사용")
    void success_Separator() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("[예외] - 음수")
    void exception_minus() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[예외] - 입력범위 초과")
    void exception_overflow() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775807123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[예외] - 문자 입력")
    void exception_notNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcabc,123,345"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("[예외] - 덧셈연산결과 범위 초과")
    void exception_overflowDuringCalculation() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775807,1"))
                        .isInstanceOf(ArithmeticException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
