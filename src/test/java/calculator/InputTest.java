package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Message.Message.OUTPUT_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {

    @Test
    @DisplayName("아무 것도 입력되지 않는 케이스")
    void blankFormula() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains(OUTPUT_MESSAGE + "0");
        });
    }

    @Test
    @DisplayName("구분자만 입력되는 케이스")
    void onlySeparator() {
        assertSimpleTest(() -> {
            run(",,:,::");
            assertThat(output()).contains(OUTPUT_MESSAGE + "0");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
