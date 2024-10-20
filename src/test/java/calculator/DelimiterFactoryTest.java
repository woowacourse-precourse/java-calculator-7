package calculator;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DelimiterFactoryTest {

    private final DelimiterFactory delimiterFactory = new DelimiterFactory();

    @Test
    void testBaseDelimiters() {
        Set<Character> delimiters = delimiterFactory.getBaseDelimiters();
        assertThat(delimiters).containsExactlyInAnyOrder(',', ':');
    }

    @Test
    void testCustomDelimiter() {
        String input = "//;\\n1;2;3";
        Set<Character> delimiters = delimiterFactory.createDelimiters(input);
        assertThat(delimiters).containsExactlyInAnyOrder(',', ':', ';');
    }
}
