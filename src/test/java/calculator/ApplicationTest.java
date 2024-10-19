package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_성공() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 음수_입력시_오류_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Suffix_커스텀_구분자_오류_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//#1#2#3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Prefix_커스텀_구분자_오류_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("/^\\n1^2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_다른거_썼을때_예외() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//^\\n1?2^3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_썼을때_성공() {
        assertSimpleTest(
                () -> {
                    run("1,2,3");
                    assertThat(output()).contains("결과 : 1");
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
