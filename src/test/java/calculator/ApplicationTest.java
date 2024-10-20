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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 기본_구분자만_포함하고_있을_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("1,2,4:6,9");
            assertThat(output()).contains("결과 : 22");
        });
    }

    @Test
    void 커스텀_구분자를_포함하고_있을_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("//^\\n1,2:3^1");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 구분자가_연속적으로_이어질_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("::1::");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자를_정의하는_형식이_올바르지_않을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/%\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_2자리_이상일_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//%^\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_아스키코드에_해당하지_않을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//가\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_아스키코드의_제어문자일_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\u001B\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자에_0에서_9까지의_숫자가_포함되어_있을_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자가_빈_문자로_이루어져_있을_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_스페이스일_경우_정상적으로_결과값을_출력한다() {
        assertSimpleTest(() -> {
            run("// \\n1 2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자가_스페이스가_아닌_공백문자일_경우_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\t\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자_이외의_문자가_발견될_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//$\\n1*"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 피연산자에_0이_포함되어_있을_경우_얘외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:0,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 피연산자가_21억일_경우_정상적으로_출력된다() {
        assertSimpleTest(() -> {
            run("2100000000:");
            assertThat(output()).contains("결과 : 2100000000");
        });
    }

    @Test
    void 피연산자가_21억을_초과할_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2100000001:1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 결과값이_21억일_경우_정상적으로_출력된다() {
        assertSimpleTest(() -> {
            run("1000000000:1100000000");
            assertThat(output()).contains("결과 : 2100000000");
        });
    }

    @Test
    void 결과값이_21억을_초과할_경우_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1000000000:1100000001"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
