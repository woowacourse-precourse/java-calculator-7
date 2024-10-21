package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 빈_문자열_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과: 0");
        });
    }

    @Test
    void 쉼표_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과: 6");
        });
    }

    @Test
    void 커스텀_구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\n1;2");
            assertThat(output()).contains("결과: 3");
        });
    }

    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수는 입력할 수 없습니다: -1");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}