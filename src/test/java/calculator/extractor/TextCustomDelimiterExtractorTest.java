package calculator.extractor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TextCustomDelimiterExtractorTest {

    TextCustomDelimiterExtractor textCustomDelimiterExtractor;

    @BeforeEach
    void before() {
        textCustomDelimiterExtractor = new TextCustomDelimiterExtractor();
    }

    @Test
    void TDD_커스텀_구분자_반환() {
        //given
        String input = "//|\\n1:2|3";

        //when
        String customDelimiter = textCustomDelimiterExtractor.extractCustomDelimiter(input);

        //then
        assertThat(customDelimiter).isEqualTo("|");
    }

    @Test
    void TDD_커스텀_구분자_제외_텍스트_반환() {
        //given
        String input = "//|\\n1:2|3";

        //when
        String text = textCustomDelimiterExtractor.extractText(input);

        //then
        assertThat(text).isEqualTo("1:2|3");
    }

    @Test
    void 커스텀_포맷_불일치_예외_구분자_여러개() {
        //given
        String input = "//||\\n1:2|3";

        //when
        assertThatThrownBy(() -> textCustomDelimiterExtractor.extractCustomDelimiter(input));
    }

    @Test
    void 커스텀_포맷_불일치_예외_끝_구분자_미존재() {
        //given
        String input = "//|\1:2|3";

        //when
        assertThatThrownBy(() -> textCustomDelimiterExtractor.extractCustomDelimiter(input));
    }
}
