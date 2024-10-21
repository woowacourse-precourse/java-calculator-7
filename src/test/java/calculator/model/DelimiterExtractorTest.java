package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.fixture.CalculatorAppFixture;
import calculator.model.implement.DelimiterExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor delimiterExtractor = CalculatorAppFixture.getDelimiterExtractor();

    @DisplayName("문자열 내 정의된 커스텀 구분자를 분리하여 반환한다.")
    @Test
    void extractCustom() {
        assertSimpleTest(() -> {
            String extractCustomDelimiter = delimiterExtractor.extractCustom("//.\\n1,2,3");
            assertThat(extractCustomDelimiter).contains(".");
        });
    }
}
