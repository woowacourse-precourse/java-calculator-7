package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomDelimiterValidationTest extends NsTest {
    @Test
    void 커스텀_구분자_성공_테스트1() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트2() {
        assertSimpleTest(() -> {
            run("//;\\n123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트3() {
        assertSimpleTest(() -> {
            run("//q\\n123q23");
            assertThat(output()).contains("결과 : 146");
        });
    }

    @Test
    void 커스텀_구분자_성공_테스트4() {
        assertSimpleTest(() -> {
            run("//-\\n123-13");
            assertThat(output()).contains("결과 : 136");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
