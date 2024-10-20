package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Message.Message.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest extends NsTest {
    @Test
    @DisplayName("문자열 정수가 양수 최댓값보다 큰 케이스")
    void overflowLong() {
        assertSimpleTest(() -> {
            run("9223372036854775808");
            assertThat(output()).contains(OVERFLOW_NUMBER_MESSAGE);
        });
    }

    @Test
    @DisplayName("문자열의 덧셈 중 오버플로우가 발생하는 케이스")
    void overflowSum() {
        assertSimpleTest(() -> {
            run("9223372036854775807,123");
            assertThat(output()).contains(OVERFLOW_SUM_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
