package calculator.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class DelimitersTest {

    @Test
    void 구분자들을_생성할_때_기본_구분자를_등록한다() {
        // given

        // when
        Delimiters delimiters = new Delimiters();

        // then
        assertThat(delimiters.getDelimiters()).containsExactly(",", ":");
    }

    @Test
    void 구분자들을_추가한다() {
        // given
        Delimiters delimiters = new Delimiters();

        // when
        delimiters.addCustomDelimiter(",");

        // then
        assertThat(delimiters.getDelimiters()).containsExactly(",");
    }

    @Test
    void 구분자들을_추가할_때_구분자가_null_값이나_빈_값일_경우_예외를_발생시킨다() {
        // given
        Delimiters delimiters = new Delimiters();

        // when & then
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> delimiters.addCustomDelimiter(null)).isInstanceOf(IllegalArgumentException.class);
            softly.assertThatThrownBy(() -> delimiters.addCustomDelimiter("")).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자들을_추가할_때_구분자가_숫자일_경우_예외를_발생시킨다() {
        // given
        Delimiters delimiters = new Delimiters();

        // when & then
        assertSoftly(softly -> {
            softly.assertThatThrownBy(() -> delimiters.addCustomDelimiter("123")).isInstanceOf(IllegalArgumentException.class);
            softly.assertThatThrownBy(() -> delimiters.addCustomDelimiter("-200")).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자들을_합치면_구분자를_이은_문자열을_반환한다() {
        // given
        Delimiters delimiters = new Delimiters();
        delimiters.addCustomDelimiter(",");
        delimiters.addCustomDelimiter(":");

        // when
        String concatenated = delimiters.concatenate();

        // then
        assertThat(concatenated).isEqualTo(",:");
    }
}
