package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class DefaultDelimiterValidationTest extends NsTest {
    @Test
    void 기본_구분자_성공_테스트1() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트2() {
        assertSimpleTest(()-> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트3() {
        assertSimpleTest(()-> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
