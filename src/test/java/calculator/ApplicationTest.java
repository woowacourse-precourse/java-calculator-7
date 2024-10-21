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
            run("//;\\n1;4;7");
            assertThat(output()).contains("결과 : 12");
        });
    }

    @Test
    void 예외_테스트() {
            assertThatThrownBy(() -> Calculator.add("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("음수가 포함되었습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
