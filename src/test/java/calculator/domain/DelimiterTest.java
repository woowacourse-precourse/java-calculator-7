package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private final Delimiter delimiter = new Delimiter();

    @Test
    void 모든_split_구분자를_확인() {
        // given
        String input = "//=\n1=2=3";

        // when
        final String allDelimiters = delimiter.getAllDelimiters(input);

        // then
        assertThat(allDelimiters).isEqualTo(",|:|=");
    }

    @Test
    void 커스텀_구분자가_없는경우_default_구분자_반환() {
        // given
        String input = "1,2,3";

        // when
        final String defaultDelimiters = delimiter.getAllDelimiters(input);

        // then
        assertThat(defaultDelimiters).isEqualTo(",|:");
    }
}
