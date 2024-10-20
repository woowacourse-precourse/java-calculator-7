package calculator.adder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class TokenTest {

    @Test
    void 요청_값을_토큰으로_생성한다() {
        // given
        String value = "1";

        // when
        Token token = new Token(value);

        // then
        assertThat(token.getValue()).isEqualTo(Integer.parseInt(value));
    }

    @Test
    void 요청_값이_blank값일_경우_0으로_변환하여_저장한다() {
        // given
        String value1 = "";
        String value2 = " ";

        // when
        Token token1 = new Token(value1);
        Token token2 = new Token(value2);

        // then
        assertSoftly(softly -> {
            softly.assertThat(token1.getValue()).isEqualTo(0);
            softly.assertThat(token2.getValue()).isEqualTo(0);
        });
    }

    @Test
    void 요청_값이_숫자가_아닐_경우_예외를_발생시킨다() {
        // given
        String value = "a";

        // when & then
        assertThatThrownBy(() -> new Token(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 요청_값이_양수가_아닐_경우_예외를_발생시킨다() {
        // given
        String value = "-1";

        // when & then
        assertThatThrownBy(() -> new Token(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
