package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("빈 문자열 입력시 결과가 0으로 출력된다.")
    void 빈_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("공백 문자열 입력시 결과가 0으로 출력된다.")
    void 공백_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run("    ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("커스텀 구분자가 정상적으로 작동하고 숫자 합산이 정확한지 확인한다.")
    void 커스텀_구분자_여러_숫자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 특수 문자를 사용했을 때 올바르게 작동하는지 확인한다.")
    void 커스텀_구분자_특수문자_테스트() {
        assertSimpleTest(() -> {
            run("//#\\n1#2#3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 공백 문자를 사용했을 때 올바르게 작동하는지 확인한다.")
    void 커스텀_구분자_공백_테스트() {
        assertSimpleTest(() -> {
            run("// \\n1 2 3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수 입력값은 허용되지 않습니다.")
        );
    }

    @Test
    @DisplayName("구분자와 숫자 외의 문자가 포함된 경우 예외가 발생한다.")
    void 숫자가_아닌_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값에 구분자와 숫자 외의 문자가 포함되어 있습니다.")
        );
    }

    @Test
    @DisplayName("숫자가 아닌 문자열이 포함된 경우 예외가 발생한다.")
    void 숫자가_아닌_문자열_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,hello,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값에 구분자와 숫자 외의 문자가 포함되어 있습니다.")
        );
    }

    @Test
    @DisplayName("연속된 구분자가 입력된 경우 예외가 발생한다.")
    void 연속된_구분자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력값에 연속된 구분자 또는 공백만 포함된 부분이 있습니다.")
        );
    }

    @Test
    @DisplayName("합산된 값이 Integer.MAX_VALUE를 초과하는 경우 예외가 발생한다.")
    void 예외_테스트_정수_오버플로우() {
        int maxValue = Integer.MAX_VALUE;
        String input = maxValue + ",1";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(ArithmeticException.class)
                        .hasMessageContaining("정수 합이 Integer 범위를 초과했습니다")
        );
    }

    @Test
    @DisplayName("//로 시작하나 \\n이 없는 경우 예외가 발생한다.")
    void 잘못된_커스텀_구분자_형식_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자의 형식이 잘못되었습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
