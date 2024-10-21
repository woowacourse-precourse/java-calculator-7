package calculator.parser;

import calculator.Seperator;
import calculator.Splitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitterTest {
    private Splitter splitter;
    private Seperator seperator;

    @BeforeEach
    void setUp() {
        splitter = new Splitter();
        seperator = new Seperator();
    }

    @Test
    @DisplayName("기본 테스트")
    void testDefaultSeparators() {
        List<Integer> result = splitter.split("1,2:3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("구분자 추가 테스트")
    void testSeparators() {
        seperator.addSeperator("$");
        List<Integer> result = splitter.split("1$2:3");
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
}