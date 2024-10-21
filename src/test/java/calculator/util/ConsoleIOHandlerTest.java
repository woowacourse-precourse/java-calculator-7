package calculator.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ConsoleIOHandlerTest {

    private ConsoleIOHandler handler;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void afterEach() {
        System.setIn(null);
        handler = new ConsoleIOHandler();
    }

    @Test
    void Read_fail_Throws_IllegalArgumentException_When_input_is_blank() throws Exception {
        //given
        final String input = " ";
        systemIn(input);

        try (ConsoleIOHandler h = handler) {
            //when, then
            assertThrows(IllegalArgumentException.class, h::read);
        }

    }
}