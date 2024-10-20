package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    @Test
    void UseCustomSeparator1() {
        RunException("//;\\n1", "결과 : 1");
    }

    @Test
    void UseCustomSeparator2() {
        RunException("//;\\n1;2,5", "결과 : 8");
    }

    private void RunException(String input, String expected) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expected);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
