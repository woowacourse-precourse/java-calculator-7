package calculator.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class DelimitersTest {

    @Test
    void 구분자들을_추가한다() {
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addDelimiter(",");

        // then
        assertThat(delimiters.getDelimiters()).containsExactly(",");
    }

    @Test
    void 구분자들을_합치면_구분자를_이은_문자열을_반환한다() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addDelimiter(",");
        delimiters.addDelimiter(":");

        // when
        String concatenated = delimiters.concatenate();

        // then
        assertThat(concatenated).isEqualTo(",:");
    }
}
