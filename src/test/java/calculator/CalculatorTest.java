package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    @Test
    void 기본_포멧_공백_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_포멧_정상_입력_숫자만_존재() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 기본_포멧_정상_입력_숫자_커스텀_구분자_존재() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_포멧_정상_입력_구분자_먼저() {
        assertSimpleTest(() -> {
            run(",12,34");
            assertThat(output()).contains("결과 : 46");
        });
    }

    @Test
    void 커스텀_포멧_공백_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_포멧_정상_입력_숫자만_존재() {
        assertSimpleTest(() -> {
            run("//[\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_포멧_정상_입력_숫자_커스텀_구분자_존재() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;34,;");
            assertThat(output()).contains("결과 : 37");
        });
    }

    @Test
    void 커스텀_포멧_정상_입력_숫자_커스텀_구분자_먼저() {
        assertSimpleTest(() -> {
            run("//;\\n;;;1;2;34,;");
            assertThat(output()).contains("결과 : 37");
        });
    }


    @Test
    void 기본_포멧_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_포멧_구분자_숫자_아닌값_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_포멧_구분자_오버플로우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3,1,2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_포멧_음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_포멧_구분자_숫자_아닌값_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2;[3]"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_포멧_구분자_오버플로우_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n2;3;1;2147483648"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Calculator.run();
    }
}