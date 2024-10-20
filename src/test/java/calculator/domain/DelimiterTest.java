package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DelimiterTest {

    @DisplayName("새로운 구분자 문자열을 추가하는 테스트")
    @Test
    void givenDelimiterString_whenAddingNewDelimiter_thenDone() throws Exception
    {
        // given
        String newDelimiter = ";";
        Delimiter delimiter = new Delimiter();
        int expected = 3;

        // when
        delimiter.addCustomDelimiter(newDelimiter);

        // then
        assertEquals(expected, delimiter.getDelimiters().size());
        assertTrue(delimiter.getDelimiters().contains(newDelimiter));
    }
}