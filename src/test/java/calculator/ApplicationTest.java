package calculator;

import static calculator.common.exception.ErrorMessage.INPUT_BLANK_ERROR;
import static calculator.common.exception.ErrorMessage.INPUT_NOT_SUPPORTED_CHAR_ERROR;
import static calculator.common.exception.ErrorMessage.OPERAND_EMPTY_ERROR;
import static calculator.common.exception.ErrorMessage.OPERAND_ZERO_OR_NEGATIVE_VALUE_ERROR;
import static calculator.common.exception.ErrorMessage.SEPARATOR_FORMAT_ERROR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열이_입력되는_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_BLANK_ERROR);
        });
    }

    @Test
    void 커스텀_구분자_제외_빈_문자열이_입력되는_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(OPERAND_EMPTY_ERROR);
        });
    }

    @Test
    void 커스텀_구분자가_하나_이상의_문자인_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//.;\\n1.;3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(SEPARATOR_FORMAT_ERROR);
        });
    }

    @Test
    void 커스텀_구분자외의_특수문자가_입력되는_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1.;3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INPUT_NOT_SUPPORTED_CHAR_ERROR);
        });
    }

    @Test
    void 음수가_입력되는_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,-3:3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(OPERAND_ZERO_OR_NEGATIVE_VALUE_ERROR);
        });
    }

    @Test
    void 영이_입력되는_경우_예외_처리한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,0:3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(OPERAND_ZERO_OR_NEGATIVE_VALUE_ERROR);
        });
    }

    @Test
    void 기본_구분자로_구분한_숫자들의_합을_출력한다() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_공백인_경우_숫자들의_합을_출력한다() {
        assertSimpleTest(() -> {
            run("// \\n1 34 2");
            assertThat(output()).contains("결과 : 37");
        });
    }

    @Test
    void 커스텀_구분자가_dollar_sign인_경우_숫자들의_합을_출력한다() {
        assertSimpleTest(() -> {
            run("//$\\n1$34$2");
            assertThat(output()).contains("결과 : 37");
        });
    }

    @Test
    void 기본_구분자와_커스텀_구분자로_구분한_숫자들의_합을_출력한다() {
        assertSimpleTest(() -> {
            run("//.\\n1.2,43");
            assertThat(output()).contains("결과 : 46");
        });
    }

    @Test
    void 문자열이_구분자로_끝나는_경우() {
        assertSimpleTest(() -> {
            run("//.\\n1.2,43:");
            assertThat(output()).contains("결과 : 46");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
