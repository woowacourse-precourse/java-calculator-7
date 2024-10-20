package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CustomDelimiterParserTest {

    @Test
    void 커스텀_구분자_사용() {
        // given
        String input = "//;\\n1";
        CustomDelimterParser customDelimterParser = new CustomDelimterParser(input);

        // when
        String customDelimiter = customDelimterParser.getCustomDelimiter().get();

        // then
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    void 커스텀_구분자_미사용() {
        // given
        String input = "1";
        CustomDelimterParser customDelimterParser = new CustomDelimterParser(input);

        // when
        boolean customDelimiter = customDelimterParser.getCustomDelimiter().isPresent();

        // then
        assertThat(customDelimiter).isFalse();
    }

    @Test
    void 컴스텀_구분자_길이가_1이_아닌_경우_예외발생() {
        // given
        String input = "//;;\\n1";
        CustomDelimterParser customDelimterParser = new CustomDelimterParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            customDelimterParser.getCustomDelimiter().get();
        });
    }
}
