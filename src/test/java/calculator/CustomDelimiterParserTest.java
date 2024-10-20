package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CustomDelimiterParserTest {

    @Test
    void 커스텀_구분자_사용_구분자_분리_성공() {
        // given
        String input = "//;\\n1";
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser(input);

        // when
        String customDelimiter = customDelimiterParser.getCustomDelimiter().get();

        // then
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    void 커스텀_구분자_미사용_구분자_분리_성공() {
        // given
        String input = "1";
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser(input);

        // when
        boolean customDelimiter = customDelimiterParser.getCustomDelimiter().isPresent();

        // then
        assertThat(customDelimiter).isFalse();
    }

    @Test
    void 컴스텀_구분자_길이가_1이_아닌_경우_실패() {
        // given
        String input = "//;;\\n1";
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterParser.getCustomDelimiter().get();
        });
    }

    @Test
    void 커스텀_구분자_제거후_문자열_올바름() {
        // given
        String input = "//;\\n1";
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser(input);

        // when
        String remainingInput = customDelimiterParser.getRemainingInput();

        // then
        assertThat(remainingInput).isEqualTo("1");
    }

    @Test
    void 커스텀_구분자_미사용_제거후_문자열_올바름() {
        // given
        String input = "1";
        CustomDelimiterParser customDelimiterParser = new CustomDelimiterParser(input);

        // when
        String remainingInput = customDelimiterParser.getRemainingInput();

        // then
        assertThat(remainingInput).isEqualTo("1");
    }
}
