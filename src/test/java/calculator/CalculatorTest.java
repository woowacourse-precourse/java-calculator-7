package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class CalculatorTest extends NsTest {

    @Test
    void 정상작동() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void long_범위초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n4000000000000000000+5000000000000000000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Calculator calculator = new Calculator();
        calculator.run();
    }
}