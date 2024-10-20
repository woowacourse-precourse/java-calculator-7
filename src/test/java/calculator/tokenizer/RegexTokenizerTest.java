package calculator.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;

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
        String input = "!";
        Delimiters delimiters = new Delimiters();
        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when
        tokenizer.setCustomDelimiter(input);

        // then
        assertThat(delimiters.getDelimiters()).contains("!");
    }
}
