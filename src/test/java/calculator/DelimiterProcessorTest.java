package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterProcessorTest {

    private DelimiterProcessor delimiterProcessor;

    @BeforeEach
    void setUp() {
        delimiterProcessor = new DelimiterProcessor();
    }

    @DisplayName("문자열을 숫자로 분리 - 숫자가 하나일 경우")
    @Test
    void extractNumberStringsWith_숫자_하나() {
        String input = "1";
        String[] result = delimiterProcessor.extractNumberStrings(input);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("기본 구분자(,|:)를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringsWith_기본_구분자() {
        String input = "1,2:3";
        String[] result = delimiterProcessor.extractNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자(;)를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringsWith_커스텀_구분자_세미콜론() {
        String input = "//;\n1;2;3";
        String[] result = delimiterProcessor.extractNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("커스텀 구분자(#)를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringsWith_커스텀_구분자_해시() {
        String input = "//#\n4#5#6";
        String[] result = delimiterProcessor.extractNumberStrings(input);
        assertThat(result).containsExactly("4", "5", "6");
    }

    @DisplayName("기본 구분자와 커스텀 구분자를 사용하여 문자열을 숫자로 분리")
    @Test
    void extractNumberStringsWith_기본_구분자_커스텀_구분자() {
        String input = "//;\n1;2,3:4";
        String[] result = delimiterProcessor.extractNumberStrings(input);
        assertThat(result).containsExactly("1", "2", "3", "4");
    }

    @DisplayName("유효하지 않은 커스텀 구분자 형식 - 커스텀 구분자가 없는 경우")
    @Test
    void invalidCustomDelimiter_커스텀_구분자_없음() {
        String input = "//\n1,2:3";
        assertThatThrownBy(() -> delimiterProcessor.extractNumberStrings(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 커스텀 구분자 형식 - 커스텀 구분자가 여러 개인 경우")
    @Test
    void invalidCustomDelimiter_커스텀_구분자_여러_개() {
        String input = "//$%\n1,2,3";
        assertThatThrownBy(() -> delimiterProcessor.extractNumberStrings(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 커스텀 구분자 형식 - \n가 없는 경우")
    @Test
    void invalidCustomDelimiter_줄바꿈이_없음() {
        String input = "//#1,2,3";
        assertThatThrownBy(() -> delimiterProcessor.extractNumberStrings(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 커스텀 구분자 형식 - //가 아니라 /인 경우")
    @Test
    void invalidCustomDelimiter_잘못된_prefix() {
        String input = "/\n1,2,3";
        assertThatThrownBy(() -> delimiterProcessor.extractNumberStrings(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 커스텀 구분자 형식 - //(.)\n가 여러 개인 경우")
    @Test
    void invalidCustomDelimiter_커스텀_구분자_반복() {
        String input = "//.\n//;\n1,2,3";
        assertThatThrownBy(() -> delimiterProcessor.extractNumberStrings(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}