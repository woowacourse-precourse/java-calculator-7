package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterExtractorTest {

    @Test
    @DisplayName("기본 구분자 반환")
    void testDefaultDelimiterAndInput() {
        String input = "1,2:3";
        String expectDelimiter = ",|:";
        String extractDelimiterAndInput = DelimiterExtractor.extractDelimiterAndInput(input);
        assertThat(extractDelimiterAndInput).isEqualTo(expectDelimiter + " " + input);
    }

    @Test
    @DisplayName("커스텀 구분자만 반환")
    void testOnlyCustomDelimiterAndInput() {
        String input = "//@\\n1@2@3";
        String expectCustomDelimiter = "@";
        String customDelimiterAndRemain = DelimiterExtractor.getCustomDelimiterAndRemain(input);
        assertThat(customDelimiterAndRemain).isEqualTo(expectCustomDelimiter + " " + "1@2@3");
    }

    @Test
    @DisplayName("커스텀 구분자 포함 전체 반환")
    void testAllDelimiterAndInput() {
        String input = "//@\\n1@2@3";
        String expectDelimiter = ",|:|@";
        String extractDelimiterAndInput = DelimiterExtractor.extractDelimiterAndInput(input);
        assertThat(extractDelimiterAndInput).isEqualTo(expectDelimiter + " " + "1@2@3");
    }

    @Test
    @DisplayName("커스텀 구분자가 기본 구분자인 경우")
    void testIsCustomSameDefault() {
        String input = "//:\\n2:3:1";
        assertThatThrownBy(() -> DelimiterExtractor.extractDelimiterAndInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우")
    void testIsNoneCustomDelimiter() {
        String input = "//\\n2:3:1";
        assertThatThrownBy(() -> DelimiterExtractor.extractDelimiterAndInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("커스텀 구분자가 여러개인 경우")
    void testIsVariousCustomDelimiter() {
        String input = "//@#\\n2#3#1";
        assertThatThrownBy(() -> DelimiterExtractor.extractDelimiterAndInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 공백인 경우")
    void testIsBlankInput() {
        String input = "";
        String expectDelimiter = ",|:";
        String extractDelimiterAndInput = DelimiterExtractor.extractDelimiterAndInput(input);
        assertThat(extractDelimiterAndInput).isEqualTo(expectDelimiter + " ");
    }

    @Test
    @DisplayName("커스텀 구분자 뒤 입력이 공백인 경우")
    void testIsBlankBehindCustomDelimiter() {
        String input = "//@\\n";
        String expectDelimiter = ",|:|@";
        String extractDelimiterAndInput = DelimiterExtractor.extractDelimiterAndInput(input);
        assertThat(extractDelimiterAndInput).isEqualTo(expectDelimiter + " ");
    }
}