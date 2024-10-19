package calculator.domain.delimiter;

import calculator.exception.BusinessException;
import calculator.exception.CalculatorExceptionMessage;
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
        List<String> result = delimiters.getAllDelimiters(input);

        // then
        assertThat(result).containsExactly(",",":","-");
    }

    @Test
    void 커스텀_구분자가_2개이상이라면_BusinessException() {
        // given
        String input = "//-;\n1-2-3";

        // when & then
        assertThatThrownBy(() -> {
            delimiters.getAllDelimiters(input);
        }).isInstanceOf(BusinessException.class)
                .hasMessageContaining(CalculatorExceptionMessage.MULTIPLE_CUSTOM_DELIMITERS_EXCEPTION.getErrorMessage());
    }

    @Test
    void 커스텀_구분자에_숫자가_존재하는경우_BusinessException() {
        // given
        String input = "//1\n11213";

        // when & then
        assertThatThrownBy(() -> {
            delimiters.getAllDelimiters(input);
        }).isInstanceOf(BusinessException.class)
                .hasMessageContaining(CalculatorExceptionMessage.DELIMITER_CANT_BLANK.getErrorMessage());
    }
}
