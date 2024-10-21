package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExecutionTest extends NsTest {

    @Test
    void 커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;1");
            assertThat(output()).contains("결과 : 2");
        });
    }

    @Test
    void 기본_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_시_아무_텍스트도_입력하지_않았을_때() {
        assertSimpleTest(() -> {
            run("//-\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_사용_시_아무_텍스트도_입력하지_않았을_때() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}