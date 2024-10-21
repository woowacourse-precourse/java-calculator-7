package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    @Test
    void 커스텀_구분자_여러_개_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2;3,4,//-\\n4-2");
            assertThat(output()).contains("결과 : 16");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
