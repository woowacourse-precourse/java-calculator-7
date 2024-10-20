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
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,-2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수는 허용되지 않습니다: -2");
        });
    }

    @Test
    void 잘못된_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,a,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 입력 값입니다.");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
