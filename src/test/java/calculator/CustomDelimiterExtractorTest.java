package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CustomDelimiterExtractorTest {

    @Test
    void 커스텀_구분자가_숫자인_경우_예외를_발생한다() {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor("<", ">");
        assertThatThrownBy(() -> customDelimiterExtractor.extractDelimiter("<1>"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 숫자일 수 없습니다.");
    }

    @Test
    void 커스텀_구분자가_존재하지_않으면_없는_결과를_반환한다() {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor("<", ">");
        DelimiterResult result = customDelimiterExtractor.extractDelimiter("1");
        assertThat(result.hasCustomDelimiter()).isFalse();
    }

    @Test
    void 커스텀_구분자가_존재하면_커스텀_구분자를_반환한다() {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor("<", ">");
        DelimiterResult result = customDelimiterExtractor.extractDelimiter("<@>2");
        assertThat(result).isEqualTo(new DelimiterResult(true, "@", "2"));
    }

    @Test
    void 커스텀_구분자의_앞글자와_뒷글자가_매칭되지_않으면_예외를_발생한다() {
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor("<", ">");
        assertThatThrownBy(() -> customDelimiterExtractor.extractDelimiter("<2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("감싸져 있어야 합니다");
    }
}
