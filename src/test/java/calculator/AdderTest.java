package calculator;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AdderTest {

    private Adder adder;

    @Nested
    class Success {

        /*
         * Used expression on success cases
         * "123:234,345,456" - Using only default delimiters
         * "123:234?345w456" - Using default and custom delimiters
         * "123:  234 ? 345  w456" - Using default and custom delimiters until expression include spaces
         */

        protected final int exprResult = 123 + 234 + 345 + 456;

        @Test
        void With_no_custom_delimiters() {
            //given
            adder = new Adder("123:234,345,456");

            //when
            final int result = adder.run();

            //then
            assertThat(result).isEqualTo(exprResult);
        }

        @Test
        void With_custom_delimiters() {
            //given
            final Set<String> delimiterSet = Set.of("?", "w");
            adder = new Adder("123:234?345w456", delimiterSet);

            //when
            final int result = adder.run();

            //then
            assertThat(result).isEqualTo(exprResult);
        }

        @Test
        void With_spaces() {
            //given
            final Set<String> delimiterSet = Set.of("?", "w");
            adder = new Adder("123:  234 ? 345  w456", delimiterSet);

            //when
            final int result = adder.run();

            //then
            assertThat(result).isEqualTo(exprResult);
        }
    }

    @Nested
    class Fails_throw_IllegalArgumentException {

        @Test
        void When_delimiter_not_found() {
            //given
            adder = new Adder("123:456?789");

            //when, then
            assertThrows(IllegalArgumentException.class,
                    () -> adder.run());
        }
    }
}