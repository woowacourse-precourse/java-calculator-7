package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
}
