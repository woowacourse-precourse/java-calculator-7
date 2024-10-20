package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.service.InputService;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputServiceTest extends NsTest {
    @Test
    void 커스텀_구분자_추출_테스트() {
        assertSimpleTest(() -> {
            Map<String, String> resultMap = InputService.extractCustomDelimiter("//r\\ntest");

            assertThat(resultMap).containsEntry("customDelimiter", "r");
            assertThat(resultMap).containsEntry("calculateString", "test");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "/qwer", "\\nasdf"})
    void 커스텀_없는_추출_테스트(String text) {
        assertSimpleTest(() -> {
            Map<String, String> resultMap = InputService.extractCustomDelimiter(text);

            assertThat(resultMap).containsEntry("customDelimiter", null);
            assertThat(resultMap).containsEntry("calculateString", text);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
