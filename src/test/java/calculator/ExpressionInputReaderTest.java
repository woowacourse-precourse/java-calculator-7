package calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.ByteArrayInputStream;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpressionInputReaderTest {

    private final ExpressionInputReader reader = new ExpressionInputReader();

    enum ExpressionTestCase {
        NO_CUSTOM_DELIMITER("123:234,345,456", "123:234,345,456", Set.of()),
        SINGLE_CUSTOM_DELIMITER("//?\n123:234?345w456", "123:234?345w456", Set.of("?")),
        MULTIPLE_CUSTOM_DELIMITER("//?\n//w\n123:  234 ? 345  w456", "123:  234 ? 345  w456", Set.of("?", "w"));

        public final String str;
        public final String expr;
        public final Set<String> delimiters;

        ExpressionTestCase(final String str, final String expr, final Set<String> delimiters) {
            this.str = str;
            this.expr = expr;
            this.delimiters = delimiters;
        }
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @AfterEach
    void afterEach() {
        System.setIn(null);
        reader.clearDelimiters();
    }

    @ParameterizedTest
    @EnumSource(ExpressionTestCase.class)
    void Success(ExpressionTestCase testCase) {
        //given
        systemIn(testCase.str);

        //when
        final String read = reader.read();

        //then
        assertThat(read).isEqualTo(testCase.expr);
        assertThat(reader.getDelimiters()).isEqualTo(testCase.delimiters);
    }

    @Nested
    class Fails_throw_IllegalArgumentException {

        @Test
        void When_input_is_blank() {
            //given
            systemIn(" ");

            //when
            //then
            assertThrows(IllegalArgumentException.class, reader::read);
        }

        @Test
        void When_custom_delimiter_contains_prefix() {
            //given
            systemIn("////\n123:234//345:456");

            //when
            //then
            assertThrows(IllegalArgumentException.class, reader::read);
        }
    }
}