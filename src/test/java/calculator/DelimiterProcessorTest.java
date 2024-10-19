package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DelimiterProcessorTest {

    @Test
    void 커스텀_구분자를_추가할_수_있다() {
        // given
        String input = "//;\n1;2;3";

        // when
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor(input);

        // then
        assertThat(delimiterProcessor.getDelimiterCount()).isEqualTo(3);
    }

    @Test
    void 다중_구분자는_예외를_발생시킨다() {
        // given
        String input = "//&^\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
                new DelimiterProcessor(input));
    }

    @Test
    void 커스텀_구분자가_없으면_기본_구분자는_두_개다() {
        // given
        String input = "1,2:3";
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor(input);

        // when
        delimiterProcessor.addDelimiterFromInput(input);

        // then
        assertThat(delimiterProcessor.getDelimiterCount()).isEqualTo(2);
    }

    @Test
    void 다중_커스텀_구분자를_처리할_수_있다() {
        // given
        String input = "//;\n1;2;3//&\n4&5&6";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new DelimiterProcessor(input));
    }

    @Test
    void 구분자가_없는_입력은_예외를_발생시킨다() {
        // given
        String input = "123";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new DelimiterProcessor(input));
    }

    @Test
    void 기본_구분자만_있는_입력을_처리할_수_있다() {
        // given
        String input = "1,2:3";

        // when
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor(input);

        // then
        assertThat(delimiterProcessor.getDelimiterCount()).isEqualTo(2); // 기본 구분자만 존재
    }
}