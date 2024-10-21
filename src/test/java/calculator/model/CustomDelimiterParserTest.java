package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import calculator.view.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CustomDelimiterParserTest extends NsTest {

    @Test
    void 커스텀_구분자가_비어있으면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.INCLUDE_NOT_NUMBER.getMessage() + "//\\n")
        );
    }

    @Test
    void 커스텀_구분자가_숫자면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n213"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.INVALID_NUMERIC_CUSTOM_DELIMITER.getMessage())
        );
    }

    @Test
    void 커스텀_구분자가_어러개면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@\\n1!2@3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.ONLY_ONE_CUSTOM_DELIMITER.getMessage())
        );
    }

    @Test
    void 커스텀_구분자를_구별하는_문자가_슬래시만_존재하면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!1!2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.INVALID_DELIMITER_POSITION.getMessage())
        );
    }

    @Test
    void 커스텀_구분자를_구별하는_문자가_개행자만_존재하면_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n!1!2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Message.INVALID_DELIMITER_POSITION.getMessage())
        );
    }

    @Test
    void 커스텀_구분자_위치_변경_사용() {
        assertSimpleTest(() -> {
            run("\\n;//1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_미사용() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
