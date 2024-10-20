package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class PlusTest extends NsTest {

    @Test
    @DisplayName("int 범위가 넘는 수가 들어올 경우")
    void bigIntegerTest() {
        assertSimpleTest(() -> {
            run("2147438648:2147438648");
            assertThat(output()).contains("결과 : 4294877296");
        });
    }

    @Test
    @DisplayName("int 범위가 넘는 수가 들어올 경우 - 커스텀 구분자 사용")
    void bigIntegerTestForCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n2147438648;2147438648");
            assertThat(output()).contains("결과 : 4294877296");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
