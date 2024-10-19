package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class StringAdditionCalculatorTest extends NsTest {

    @Test
    void 기본구분자_숫자추출_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("[1, 2, 3]");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
