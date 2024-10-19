package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class PlusTest extends NsTest {
    @Test
    void testStringToInteger() {
        assertSimpleTest(() -> {
            String[] test = {"1", "2", "3"};
            Plus obj = new Plus();

            for (int i = 0; i < test.length; i++) {
                assertThat(obj.convertToInteger(test[i])).isEqualTo(i + 1);
            }
        });
    }

    @Test
    void testPlus() {
        assertSimpleTest(() -> {
            int[] test = {1, 2, 3};
            Plus obj = new Plus();
            int result = 0;
            for (int i = 0; i < test.length; i++) {
                result += obj.plus(test[i]);
            }
            assertThat(result).isEqualTo(6);
        });
    }

    @Override
    protected void runMain() {

    }
}
