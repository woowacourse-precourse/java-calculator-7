package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest extends NsTest {

    @Test
    @DisplayName("문자열 덧셈 계산기를 실행한다.")
    void testStringPlusCalculator() {
        assertSimpleTest(() -> {
            run("6");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("//@\\n1,2@3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("//@\\n1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
