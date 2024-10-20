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

    @Test
    void testCalcMethod() {
        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("1,2");
            assertThat(result).isEqualTo(3);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("1,2,3");
            assertThat(result).isEqualTo(6);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("1,2:3");
            assertThat(result).isEqualTo(6);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("1,2:3");
            assertThat(result).isEqualTo(6);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("//;\\n1;2;3");
            assertThat(result).isEqualTo(6);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("//;\\n1,2;3:4");
            assertThat(result).isEqualTo(10);
        });

        assertSimpleTest(() -> {
            Calculator obj = new Calculator();
            int result = obj.calc("//!\\n1,2!3!4");
            assertThat(result).isEqualTo(10);
        });

    }

    @Override
    protected void runMain() {

    }
}
