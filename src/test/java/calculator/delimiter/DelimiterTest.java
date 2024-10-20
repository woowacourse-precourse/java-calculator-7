package calculator.delimiter;

import calculator.command.DelimiterLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {

    @Test
    @DisplayName("기본 구분자로 분리 가능")
    void test1() {
        String numberLine = "1:2,3";
        Delimiter delimiter = Delimiter.DEFAULT_DELIMITER;

        assertArrayEquals(delimiter.split(numberLine), new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("주어진 구분자로 분리 가능")
    void test2() {
        String numberLine = "1a2a3";
        Delimiter delimiter = Delimiter.create(createLine("a"));

        assertArrayEquals(delimiter.split(numberLine), new String[]{"1","2","3"});
    }

//    @Test
    @DisplayName(". 구분자로 분리 가능")
    void testEdge() {
        String numberLine = "1.2.3";
        Delimiter delimiter = Delimiter.create(createLine("."));

        assertArrayEquals(delimiter.split(numberLine), new String[]{"1","2","3"});
    }

    @Test
    @DisplayName("구분자를 주지 않는다면 예외 발생")
    void test3() {
        assertThrows(IllegalArgumentException.class, () -> Delimiter.create(null));
    }

    @Test
    @DisplayName("구분자를 단일 문자로 주지 않는다면 예외 발생")
    void test4() {
        assertThrows(IllegalArgumentException.class, () -> Delimiter.create(createLine("Something")));
    }

    @Test
    @DisplayName("빈 라인은 디폴트 구분자를 반환")
    void test5() {
        Assertions.assertThat(Delimiter.create(DelimiterLine.EMPTY_LINE)).isEqualTo(Delimiter.DEFAULT_DELIMITER);
    }

    private static DelimiterLine createLine(String value) {
        return new DelimiterLine(value);
    }
}