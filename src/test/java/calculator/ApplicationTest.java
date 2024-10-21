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
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자_사용 () {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구분자_음수_예외 () {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 양수만 입력할 수 있습니다.")
        );
    }

    @Test
    void 기본_구분자_0_예외 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("숫자는 양수만 입력할 수 있습니다.")
        );
    }

    @Test
    void 기본_구분자_오입력_예외 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 입력값이 있습니다: ")
        );
    }

    @Test
    void 커스텀_구분자_오입력_예외 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2k3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 입력값이 있습니다: ")
        );
    }

    @Test
    void 커스텀_구분자_미입력_예외 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자가 없습니다.")
        );
    }

    @Test
    void 커스텀_구분자_형식_예외 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/\\n1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자 입력은 //으로 시작해야합니다.")
        );
    }

    @Test
    void 커스텀_구분자_형식_예외2 () {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자는 입력은 \\n 로 끝나야합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
