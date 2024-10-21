package calculator;

import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CustomDelimiterValidationTest extends NsTest {

    // 성공 케이스 테스트
    @Test
    void 커스텀_구분자_성공_테스트1() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트2() {
        assertSimpleTest(() -> {
            run("//;\\n123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트3() {
        assertSimpleTest(() -> {
            run("//q\\n123q23");
            assertThat(output()).contains("결과 : 146");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트4() {
        assertSimpleTest(() -> {
            run("//-\\n123-13");
            assertThat(output()).contains("결과 : 136");
        });
    }

    // 실패 케이스 테스트
    @Test
    void 커스텀_구분자_실패_테스트1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//qw\\n123qw23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트2_숫자포함() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//5\\n123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트3_잘못된문자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//[\\n123]23"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트4_특수문자오류() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//[\\n123[-23[7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트5_잘못된포맷() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//a\\n1;2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트6_빈구분자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//\\n123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 커스텀_구분자_실패_테스트7_연속된구분자() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;;2;;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
