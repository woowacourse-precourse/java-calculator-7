package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.SingleCustomDelimiterParser;
import org.junit.jupiter.api.Test;

public class SingleCustomDelimiterParserTest {

    @Test
    void 커스텀_구분자_사용_구분자_분리_성공() {
        // given
        String input = "//;\\n1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when
        String customDelimiter = singleCustomDelimiterParser.getCustomDelimiter().get().getValue();

        // then
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    void 커스텀_구분자_미사용_구분자_분리_성공() {
        // given
        String input = "1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when
        boolean customDelimiter = singleCustomDelimiterParser.getCustomDelimiter().isPresent();

        // then
        assertThat(customDelimiter).isFalse();
    }

    @Test
    void 컴스텀_구분자_길이가_1이_아닌_경우_실패() {
        // given
        String input = "//;;\\n1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            singleCustomDelimiterParser.getCustomDelimiter().get();
        });
    }

    @Test
    void 커스텀_구분자_제거후_문자열_올바름() {
        // given
        String input = "//;\\n1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when
        String remainingInput = singleCustomDelimiterParser.getRemainingInput();

        // then
        assertThat(remainingInput).isEqualTo("1");
    }

    @Test
    void 커스텀_구분자_미사용_제거후_문자열_올바름() {
        // given
        String input = "1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when
        String remainingInput = singleCustomDelimiterParser.getRemainingInput();

        // then
        assertThat(remainingInput).isEqualTo("1");
    }

    @Test
    void 비어있는_커스텀_구분자_실패() {
        // given
        String input = "//\\n1";
        SingleCustomDelimiterParser singleCustomDelimiterParser = new SingleCustomDelimiterParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> {
            singleCustomDelimiterParser.getCustomDelimiter().get();
        });
    }
}
