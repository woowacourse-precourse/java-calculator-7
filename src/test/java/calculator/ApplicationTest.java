package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.ErrorCode;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 기본_구분자와_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("1//;\\n2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_두개_이상_사용() {
        assertSimpleTest(() -> {
            run("1//;\\n2//'\\n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_알파벳인_이상_사용() {
        assertSimpleTest(() -> {
            run("1//a\\n2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_선언_이후_다시_사용() {
        assertSimpleTest(() -> {
            run("1//;\\n2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.EMPTY_INPUT.getMessage())
        );
    }

    @Test
    void 커스텀_형식_오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1//;\\\n2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.INVALID_CUSTOM_SEPARATOR.getMessage())
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.NON_POSITIVE_NUMBER.getMessage())
        );
    }

    @Test
    void 커스텀_구분자_두글자_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.INVALID_CUSTOM_SEPARATOR_LENGTH.getMessage())
        );
    }

    @Test
    void 커스텀_구분자_숫자_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.NUMERIC_CUSTOM_SEPARATOR.getMessage())
        );
    }

    @Test
    void 공백_커스텀_구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.BLANK_CUSTOM_SEPARATOR.getMessage())
        );
    }

    @Test
    void 문자열_형식_오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorCode.INVALID_NUMBER_FORMAT.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
