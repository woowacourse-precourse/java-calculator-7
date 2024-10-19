package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ValidatorTest extends NsTest {
    @Test
    void testIsInputContainNegative() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                Validator obj = new Validator();
                obj.validate("-1:2,-3");
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testCustomSeparatorIsCorrectConvention() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                Validator obj = new Validator();
                obj.validate("//;1;2;3");
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void testCustomSeparatorIsOneSize() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                Validator obj = new Validator();
                obj.validate("//!@\\n;1;2;3");
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {

    }
}
