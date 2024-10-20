package calculator.split;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SeperatorTest {
    private Seperator seperator;

    @BeforeEach
    void setUp() {
        seperator = new Seperator();
    }

    @Test
    @DisplayName("기본 구분자 테스트")
    void testDefaultSeperators() {
        Set<String> defaultSeperators = seperator.getSeperators();
        assertEquals(2, defaultSeperators.size());
        assertTrue(defaultSeperators.contains(","));
        assertTrue(defaultSeperators.contains(":"));
    }

    @Test
    @DisplayName("구분자 추가 테스트")
    void testAddSeperator() {
        seperator.addSeperator(";");
        Set<String> seperators = seperator.getSeperators();
        assertEquals(3, seperators.size());
        assertTrue(seperators.contains(";"));
    }

    @Test
    @DisplayName("중복된 구분자 추가 테스트")
    void testAddDuplicateSeperator() {
        seperator.addSeperator(",");
        assertEquals(2, seperator.getSeperators().size());
    }

    @Test
    @DisplayName("추가할 구분자 없음 테스트")
    void testAddEmptySeperator() {
        seperator.addSeperator("");
        assertEquals(2, seperator.getSeperators().size());
    }

}