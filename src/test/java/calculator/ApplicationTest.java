package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3");
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양수를 입력해 주세요.")
        );
    }

    @Test
    void 제로_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("양수를 입력해 주세요.")
        );
    }

    @Test
    void 커스텀_구분자_누락_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자를 입력해 주세요.")
        );
    }

    @Test
    void 잘못된_커스텀_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1$2$3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("올바르지 않은 커스텀 구분자입니다.")
        );
    }

    @Test
    void 잘못된_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1$2$3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("올바르지 않은 구분자입니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
