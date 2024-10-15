package calculator;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    Application app = new Application();
    @Test
    void extractCustomSeparator_case1() {
        String input = "//;\n1;2;3";
        List<Character> separators = app.extractCustomSeparator(input);
        assertEquals(1, separators.size());
        assertEquals(';', separators.get(0));
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
            String input = "1,2:3";
            List<Character> separators = app.extractCustomSeparator(input);
            assertTrue(separators.isEmpty());
        }

        @Test
        void extractCustomSeparator_case4() {
            String input = "//\n\n1,2,3";
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                app.extractCustomSeparator(input);
            });
            assertEquals("구분자는 반드시 하나의 문자여야 합니다.", exception.getMessage());
        }
    }

