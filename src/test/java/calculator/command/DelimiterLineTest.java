package calculator.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DelimiterLineTest {

    @Test
    @DisplayName("길이, 형식에 상관없이 구분자 저장 가능")
    void test1() {
        String testValue = "abc\n";

        DelimiterLine result = new DelimiterLine(testValue);

        assertThat(result.value()).isEqualTo(testValue);
        assertThat(result.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("공백 구분자와 EMPTY_LINE는 엄연히 다름")
    void testDelimiter2() {
        String testValue = "";

        DelimiterLine result = new DelimiterLine(testValue);

        assertThat(result.value()).isEqualTo(testValue);
        assertThat(result.isEmpty()).isFalse();
        assertThat(result).isNotEqualTo(DelimiterLine.EMPTY_LINE);
        assertThat(DelimiterLine.EMPTY_LINE.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("EMPTY_LINE은 value를 사용할 수 없음")
    void testDelimiter3() {
        assertThrows(IllegalStateException.class, DelimiterLine.EMPTY_LINE::value);
    }
}