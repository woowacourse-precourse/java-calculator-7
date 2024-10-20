package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class DelimiterTest {

    @Test
    void 기본_구분자_확인_테스트() {
        Delimiter delimiter = new Delimiter();

        assertThat(delimiter.getRegex().contains(",")).isTrue();
        assertThat(delimiter.getRegex().contains(":")).isTrue();
        assertThat(delimiter.getRegex().contains("!")).isFalse();
    }

    @Test
    void 커스텀_구분자_추가_테스트() {
        Delimiter delimiter = new Delimiter();

        delimiter.addCustomDelimiter("!'/@");

        assertThat(delimiter.getRegex().contains("!")).isTrue();
        assertThat(delimiter.getRegex().contains("'")).isTrue();
        assertThat(delimiter.getRegex().contains("@")).isTrue();
        assertThat(delimiter.getRegex().contains("/")).isTrue();
        assertThat(delimiter.getRegex().contains("*")).isFalse();
        assertThat(delimiter.getRegex().contains("+")).isFalse();
    }

    @Test
    void 커스텀_구분자로_숫자를_입력한_경우() {
        Delimiter delimiter = new Delimiter();
        DelimiterParser dp = new DelimiterParser();

        String input = "//1\\n112131415";
        String customDelimiter = dp.findCustomDelimiter(input);

        assertThatThrownBy(() -> delimiter.addCustomDelimiter(customDelimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
}