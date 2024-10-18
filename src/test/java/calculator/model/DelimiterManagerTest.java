package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.fixture.CalculatorAppFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterManagerTest {

    private final DelimiterManager delimiterManager = CalculatorAppFixture.createDelimiterManager();
    private final DelimiterStore delimiterStore = CalculatorAppFixture.getDelimiterStore();

    @DisplayName("입력값에 커스텀구분자가 있으면 true를 반환한다.")
    @Test
    void existCustomDelimiter() {
        assertSimpleTest(() -> {
            boolean result = delimiterManager.existCustomDelimiter("//.\\n1,2,3");
            assertTrue(result);
        });
    }

    @DisplayName("문자열 내에 커스텀 구분자를 DelimiterStore에 등록한다.")
    @Test
    void registerCustomDelimiters() {
        assertSimpleTest(() -> {
            delimiterManager.registerCustomDelimiters("//.\\n1,2,3");
            assertThat(delimiterStore.getAllDelimiters()).contains(".");
        });
    }
}
