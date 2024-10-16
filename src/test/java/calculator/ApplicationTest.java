package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    Application app = new Application();

    @Test
    void extractCustomSeparator_case1() {
        String input = "//;\n1;2;3";

        Character separator = app.extractCustomSeparator(input);

        assertEquals(';', separator.charValue());
    }

    @Test
    void extractCustomSeparator_case2() {
        String input = "//***\n1***2***3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.extractCustomSeparator(input);
        });

        assertEquals("구분자는 반드시 하나의 문자여야 합니다.", exception.getMessage());
    }

    @Test
    void extractCustomSeparator_case3() {
        String input = "//<.\n1,2,3";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.extractCustomSeparator(input);
        });

        assertEquals("구분자는 반드시 하나의 문자여야 합니다.", exception.getMessage());
    }

    @Test
    void removeDeclarePart_case1() {
        String input = "//-\n1-5-15";
        Character customSeparator = '-';

        String removedDeclarePart = app.removeDeclarePart(input, customSeparator);

        assertEquals(customSeparator, "1-5-15");
    }

    @Test
    void removeDeclarePart_case2() {
        String input = "1,1,5";
        Character customSeparator = null;

        String removedDeclarePart = app.removeDeclarePart(input, customSeparator);

        assertEquals(input, "1,1,5");
    }
}
