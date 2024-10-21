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
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertThatThrownBy(() -> {
            StringCalculator.add("-1,2,3");  // 음수 입력
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 불가능 합니다");
    }

    @Test
    void 잘못된_숫자_예외_테스트() {
        assertThatThrownBy(() -> {
            StringCalculator.add("1,a,3");  // 숫자가 아닌 값 포함
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
