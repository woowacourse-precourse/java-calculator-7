package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {
    private DelimiterExtractor delimiterExtractor;

    @BeforeEach
    void setUp() {
        delimiterExtractor = new DelimiterExtractor();
    }

    @Test
    void 커스텀_구분자_포함() {
        String s = "//^\n3^4,2;5";
        assertEquals(Set.of(",", ";", "^"), delimiterExtractor.extract(s));
    }

    @Test
    void 커스텀_구분자_미포함() {
        String s = "3,4,2;5";
        assertEquals(Set.of(",", ";"), delimiterExtractor.extract(s));
    }

    private void assertStringArrayEqualsIgnoreOrder(String[] expected, String[] actual) {
        assertEquals(expected.length, actual.length, "Arrays have different lengths");

        Set<String> expectedSet = new HashSet<>(Arrays.asList(expected));
        Set<String> actualSet = new HashSet<>(Arrays.asList(actual));

        assertEquals(expectedSet, actualSet, "Arrays contain different elements");
    }
}