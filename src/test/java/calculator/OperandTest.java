package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class OperandTest extends NsTest {

    @Test
    void 피연산자는_음수이거나_0일_수_없다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("-1"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> run("0"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 피연산자는_문자일_수_없다(){
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }





    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
