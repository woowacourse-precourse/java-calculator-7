package calculator.outputhandler;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class OutputHandlerTest extends NsTest {

    @Test
    void printResult() {
        String prompt = "결과 : ";
        String result = "3";

        assertSimpleTest(() -> {
            OutputHandler.printResult(prompt, result);
            assertThat(output()).contains(prompt + result);
        });
    }

    @Override
    protected void runMain() {

    }
}