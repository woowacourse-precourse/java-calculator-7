package calculator.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RegexPatternMatcherTest {
    @Test
    @DisplayName("Test countMatches() method")
    void testCountMatches() {
        RegexPatternMatcher regexPatternMatcher = new RegexPatternMatcher("//(.*?)\n");
        assertEquals("a", regexPatternMatcher.getMatch("//a\n"));
    }

}