package calculator.delimiter;

import calculator.command.DelimiterLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterRegexTest {

    @Test
    @DisplayName("기본 구분자로 분리 가능")
    void test1() {
        String numberLine = "1:2,3";
        DelimiterRegex delimiterRegex = DelimiterRegex.DEFAULT;

        assertArrayEquals(delimiterRegex.split(numberLine), new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("주어진 구분자로 분리 가능")
    void test2() {
        String numberLine = "1a2a3";
        DelimiterRegex delimiterRegex = DelimiterRegex.create(createLine("a"));

        assertArrayEquals(delimiterRegex.split(numberLine), new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("구분자를 주지 않는다면 예외 발생")
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> DelimiterRegex.create(null));
    }

    @Test
    @DisplayName("구분자를 단일 문자로 주지 않는다면 예외 발생")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> DelimiterRegex.create(createLine("Something")));
    }

    @Test
    @DisplayName("빈 라인은 디폴트 구분자를 반환")
    void test5() {
        Assertions.assertThat(DelimiterRegex.create(DelimiterLine.EMPTY_LINE)).isEqualTo(DelimiterRegex.DEFAULT);
    }

    @Test
    @DisplayName(". 구분자로 분리 가능")
    void test6() {
        String numberLine = "1.2.3";
        DelimiterRegex delimiterRegex = DelimiterRegex.create(createLine("."));

        assertArrayEquals(delimiterRegex.split(numberLine), new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("공백 구분자로 분리 가능")
    void test7() {
        String numberLine = "1 2 3";
        DelimiterRegex delimiterRegex = DelimiterRegex.create(createLine(" "));

        assertArrayEquals(delimiterRegex.split(numberLine), new String[]{"1","2","3"});
    }

    private static DelimiterLine createLine(String value) {
        return new DelimiterLine(value);
    }
}