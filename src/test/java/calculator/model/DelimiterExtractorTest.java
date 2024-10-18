package calculator.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import calculator.fixture.CalculatorAppFixture;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {

    private final DelimiterExtractor delimiterExtractor = CalculatorAppFixture.getDelimiterExtractor();

    @DisplayName("문자열 내 정의된 커스텀 구분자를 분리하여 List로 반환한다.")
    @Test
    void extractCustom() {
        assertSimpleTest(() -> {
            List<String> extractCustomDelimiters = delimiterExtractor.extractCustom("//.\\n1,2,3");
            assertThat(extractCustomDelimiters).contains(".");
        });
    }

    @DisplayName("커스텀 구분자를 2개 이상 정의하면 정의한 구분자 모두 List에 담아 반환한다.")
    @Test
    void extractCustomAll() {
        assertSimpleTest(() -> {
            List<String> extractCustomDelimiters = delimiterExtractor.extractCustom("//;\\n//.\\n1;2.3");
            assertThat(extractCustomDelimiters).contains(".",";");
        });
    }
}
