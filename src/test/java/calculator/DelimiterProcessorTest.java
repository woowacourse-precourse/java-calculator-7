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
    void 다중_문자_구분자는_예외를_발생시킨다() {
        // given
        String input = "//&^\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
                new DelimiterProcessor(input));
    }

    @Test
    void 커스텀_구분자가_없으면_구분자는_두_개다() {
        // given
        String input = "1,2:3";
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor(input);

        // when
        delimiterProcessor.addDelimiterFromInput(input);

        // then
        assertThat(delimiterProcessor.getDelimiterCount()).isEqualTo(2);
    }

}