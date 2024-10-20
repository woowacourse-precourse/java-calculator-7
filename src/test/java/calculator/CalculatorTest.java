package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends NsTest {
    @Test
    void testIsInputEmpty() {
        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("");
            assertThat(result).isEqualTo(0);
        });
    }

    @Override
    protected void runMain() {

    }
}
