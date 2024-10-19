package calculator.tokenizer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class RegexTokenizerTest {

    @Test
    void 입력_문자열을_구분자_단위로_구분하여_응답값을_반환한다() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addDelimiter(",");
        delimiters.addDelimiter(":");

        Tokenizer tokenizer = new RegexTokenizer(delimiters);

        // when
        String input = "1,2:3";
        TokenResponse tokenResponse = tokenizer.parse(input);

        // then
        List<String> seperatedValues = tokenResponse.getSeperatedValues();
        Assertions.assertThat(seperatedValues).containsExactly("1", "2", "3");
    }
}
