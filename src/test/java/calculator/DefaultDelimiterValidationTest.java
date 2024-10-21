package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultDelimiterValidationTest extends NsTest {

    // 성공 케이스 테스트
    @Test
    void 기본_구분자_성공_테스트1_쉼표() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트2_콜론() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트3_쉼표_콜론_혼합() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트4_빈입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // 실패 케이스 테스트
    @Test
    void 기본_구분자_실패_테스트1_연속된쉼표() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 기본_구분자_실패_테스트2_연속된콜론() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1::2:3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 기본_구분자_실패_테스트3_쉼표와잘못된문자혼용() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Test
    void 기본_구분자_실패_테스트4_음수입력() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_TYPE.getErrorMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
