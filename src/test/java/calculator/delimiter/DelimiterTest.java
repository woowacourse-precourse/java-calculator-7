package calculator.delimiter;

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
        String numberLine = "1;2;3";
        Delimiter delimiter = Delimiter.create(";");

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
        assertThrows(IllegalArgumentException.class, () -> Delimiter.create("Something"));
    }
}