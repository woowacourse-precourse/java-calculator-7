package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DelimitersTest {

    @Nested
    class Check_fail_Throws_IllegalArgumentException {

        @Test
        void When_contains_custom_delimiter_prefix() {
            //given
            Delimiters delimiters = Delimiters.of(",", ":", "//");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Delimiters.check(delimiters));
        }

        @Test
        void When_contains_custom_delimiter_suffix() {
            //given
            Delimiters delimiters = Delimiters.of(",", ":", "\\n", "");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Delimiters.check(delimiters));
        }

        @Test
        void When_delimiter_is_numeric() {
            //given
            Delimiters delimiters = Delimiters.of(",", ":", "123");

            //when, then
            assertThrows(IllegalArgumentException.class, () -> Delimiters.check(delimiters));
        }
    }
}
