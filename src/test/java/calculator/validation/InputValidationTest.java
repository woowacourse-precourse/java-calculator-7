package calculator.validation;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest extends NsTest {

    @Test
    void 구분자로_문자열_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1ab2ab3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_토큰_포함_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\n1b23b4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_0_포함_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\n1b2b0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}