package calculator.domain.delimiter;

import calculator.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DelimitersTest {

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

    @Test
    void 커스텀_구분자가_2개이상이라면_오류() {
        // given
        String input = "//-;\n1-2-3";

        // when & then
        assertThatThrownBy(() -> {
            delimiters.getAllDelimiters(input);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 커스텀_구분자가_비어있는경우_오류() {
        // given
        String input = "//\n1-2-3";

        // when & then
        assertThatThrownBy(() -> {
            delimiters.getAllDelimiters(input);
        }).isInstanceOf(BusinessException.class);
    }

    @Test
    void 커스텀_구분자가_비어있는경우_오류2() {
        // given
        String input = "//-\n1-2-3";

        // when & then
        delimiters.getAllDelimiters(input);
    }
}
