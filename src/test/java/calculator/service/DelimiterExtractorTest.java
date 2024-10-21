package calculator.service;

import calculator.domain.DelimiterSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterExtractorTest {

    private DelimiterExtractor delimiterExtractor;

    @BeforeEach
    void setUp() {
        delimiterExtractor = new DelimiterExtractor();
    }

    @Test
    @DisplayName("기본 구분자가 반환되어야 한다.")
    void shouldReturnDefaultDelimitersWhenNoPrefix() {
        String input = "1,2:3";
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(input);

        assertThat(delimiterSet.getSplitForm())
                .contains(",", ":");
    }

    @Test
    @DisplayName("커스텀 구분자가 포함되어 있어야 한다.")
    void shouldExtractCustomDelimiter() {
        String input = "//;\\n1;2";
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(input);

        assertThat(delimiterSet.hasCustom()).isTrue();
        assertThat(delimiterSet.getSplitForm()).contains(";");
    }

    @Test
    @DisplayName("접두사가 없으면 기본 구분자로 처리되어야 한다.")
    void shouldHandleWithoutPrefix() {
        String input = "1,2,3";
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(input);

        assertThat(delimiterSet.hasCustom()).isFalse();
        assertThat(delimiterSet.getSplitForm()).contains(",", ":");
    }

    @Test
    @DisplayName("구분자 없이 빈 문자열 반환")
    void shouldReturnEmptyDelimiterWhenNoSuffix() {
        String input = "//\n1,2,3";
        DelimiterSet delimiterSet = delimiterExtractor.extractDelimiter(input);

        assertThat(delimiterSet.hasCustom()).isFalse();
    }
}
