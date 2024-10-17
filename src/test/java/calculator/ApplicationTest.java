package calculator;

import static calculator.constant.ErrorMessages.INVAILD_CHAR_MESSAGE;
import static calculator.constant.ErrorMessages.INVALID_DELIMITER_MESSAGE;
import static calculator.constant.ErrorMessages.NUMBER_ASSIGN_ERROR_MESSAGE;
import static calculator.constant.OutputMessages.FIRST_MESSAGE;
import static calculator.constant.OutputMessages.RESULT_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 빈_입력_상태() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains(FIRST_MESSAGE, RESULT_MESSAGE + "0");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains(FIRST_MESSAGE, RESULT_MESSAGE + "6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;@\\n1;2@3");
            assertThat(output()).contains(FIRST_MESSAGE, RESULT_MESSAGE + "6");
        });
    }

    @Test
    void 커스텀_구분자_중복_등록() {
        assertSimpleTest(() -> {
            run("//;;\\n1;2;3");
            assertThat(output()).contains(FIRST_MESSAGE, RESULT_MESSAGE + "6");
        });
    }

    @Test
    void 커스텀_구분자_숫자_등록_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1,2,3:1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(NUMBER_ASSIGN_ERROR_MESSAGE)
        );
    }

    @Test
    void 커스텀_구분자_등록_예외1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///\\n1,2,3:1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVAILD_CHAR_MESSAGE)
        );
    }

    @Test
    void 커스텀_구분자_등록_예외2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\\\n1,2,3:1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVAILD_CHAR_MESSAGE)
        );
    }

    @Test
    void 커스텀_구분자_등록_예외3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVAILD_CHAR_MESSAGE)
        );
    }

    @Test
    void 커스텀_구분자_등록시_문자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[\\n-1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_DELIMITER_MESSAGE + '-')
        );
    }

    @Test
    void 구분자_중복_사용() {
        assertSimpleTest(() -> {
            run("1,,2::34,:5");
            assertThat(output()).contains(FIRST_MESSAGE, RESULT_MESSAGE + "15");
        });
    }

    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_DELIMITER_MESSAGE + '-')
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
