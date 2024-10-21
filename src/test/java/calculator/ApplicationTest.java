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
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_특수문자_사용() {
        assertSimpleTest(() -> {
            run("//*\\n3*4*5");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 빈값_입력시_0으로_출력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_테스트_0을_입력받을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("양수만 입력해주세요")
        );
    }

    @Test
    void 예외_테스트_음수를_입력받을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("양수만 입력해주세요")
        );
    }

    @Test
    void 예외_테스트_잘못된_문자를_입력받을_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2k,23"))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("입력하신 숫자에 잘못된 문자가 포함되어 있습니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
