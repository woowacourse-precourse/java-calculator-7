package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
    @Test
    void removeSeparators_case1() {
        String input = "1,12:3;4";
        char customSeparator = ';';

        String[] removedSeparatorsArray = app.removeSeparators(input, customSeparator);

        String[] expectedArray = {"1", "12", "3", "4"};
        assertArrayEquals(expectedArray, removedSeparatorsArray);
    }

    @Test
    void parseStringToInteger_case1() {
        String[] removedSeparatorsArray = {"1", "12", "3", "4"};

        List<Integer> parsedIntegers = app.parseStringToInteger(removedSeparatorsArray);

        List<Integer> expectedArray = Arrays.asList(1, 12, 3, 4);
        assertEquals(expectedArray, parsedIntegers);
    }

    @Test
    void sumInteger_case1() {
        List<Integer> parsedIntegers = Arrays.asList(1, 12, 3, 4);

        int sumOfIntegers = app.sumInteger(parsedIntegers);

        assertEquals(20, sumOfIntegers);
    }

    @Test
    void checkSeparatorException_missingNewline() {
        String input = "//;1;2;3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.checkSeparatorException(input);
        });
        assertEquals("구분자 형식 오류: 구분자 선언부에 '\\n'이 없습니다.", exception.getMessage());
    }

    @Test
    void checkSeparatorException_multipleCharactersInDelimiter() {
        String input = "//;;\n1;2;3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            app.checkSeparatorException(input);
        });
        assertEquals("구분자 형식 오류: 구분자는 반드시 하나의 문자여야 합니다.", exception.getMessage());
    }
}
