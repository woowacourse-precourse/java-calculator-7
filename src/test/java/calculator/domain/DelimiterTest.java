package calculator.domain;

import calculator.domain.delimiter.Delimiters;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimiterTest {

    private final Delimiters delimiters = new Delimiters();

    @Test
    void 모든_split_구분자를_확인() {
        // given
        String input = "//=\n1=2=3";

        // when
        final List<String> allDelimiters = delimiters.getAllDelimiters(input);

        // then
        assertThat(allDelimiters).containsExactly(",", ":", "=");
    }

    @Test
    void 커스텀_구분자가_없는경우_default_구분자_반환() {
        // given
        String input = "1,2,3";

        // when
        final List<String> allDelimiters = delimiters.getAllDelimiters(input);

        // then
        assertThat(allDelimiters).containsExactly(",",":");
    }

    @Test
    void 커스텀_구분자가_존재하는지_여부_확인() {
        // given
        String input = "//-\n1-2-3";

        // when
        final boolean result = delimiters.hasCustomDelimiter(input);

        // then
        assertThat(result).isTrue();
    }
}
