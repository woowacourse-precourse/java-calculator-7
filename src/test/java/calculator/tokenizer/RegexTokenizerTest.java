package calculator.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class RegexTokenizerTest {

    @Test
    void 입력_문자열을_구분자_단위로_구분하여_응답값을_반환한다() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiter(",");
        delimiters.addCustomDelimiter(":");

        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when
        String input = "1,2:3";
        TokenResponse tokenResponse = tokenizer.parse(input);

        // then
        List<String> seperatedValues = tokenResponse.getSeperatedValues();
        assertThat(seperatedValues).containsExactly("1", "2", "3");
    }

    @Test
    void 입력_문자열에_커스텀_구분자를_추가하는_구문이_있다면_커스텀_구분자를_추가한다() {
        // given
        String input = "//!\\n1:2,3";
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when
        tokenizer.setCustomDelimiter(input);

        // then
        assertThat(delimiters.getDelimiters()).contains("!");
    }

    @Test
    void 커스텀_구분자를_추가할_때_개행_문자가_없다면_추가하지_않고_통과한다() {
        // given
        String input = "//!1:2,3";
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when
        tokenizer.setCustomDelimiter(input);

        // then
        assertThat(delimiters.getDelimiters()).doesNotContain("!");
    }

    @Test
    void 커스텀_구분자를_추가할_때_등록_문자가_없다면_예외를_발생시킨다() {
        // given
        String input = "!\\n1:2,3";
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when & then
        assertThatThrownBy(() -> tokenizer.setCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
