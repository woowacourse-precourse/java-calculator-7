package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    Delimiter delimiter;

    @Test
    void 커스텀_구분자_확인() {
        delimiter = new Delimiter("//asd\\n1asd2asd3");
        assertEquals("asd", delimiter.get());
        delimiter = new Delimiter("//\\n123");
        assertEquals("", delimiter.get());
    }

    @Test
    void 커스텀_구분자_없는_상황() {
        delimiter = new Delimiter("1,2,3:4");
        assertEquals("[,:]", delimiter.get());
    }

    @Test
    void 커스텀_구분자_isCustomDelimiter_확인() {
        delimiter = new Delimiter("//asd\\n1asd2asd3");
        assertEquals(true, delimiter.isCustomDelimiter());
        delimiter = new Delimiter("//\\n123");
        assertEquals(true, delimiter.isCustomDelimiter());
    }

    @Test
    void 기본_구분자_isCustomDelimiter_확인() {
        delimiter = new Delimiter("1,2,3,4,5,6");
        assertEquals(false, delimiter.isCustomDelimiter());
    }

    @Test
    void 커스텀_구분자_size_확인() {
        delimiter = new Delimiter("//asd\\n1asd2asd3");
        assertEquals(3, delimiter.size());
        delimiter = new Delimiter("//\\n123");
        assertEquals(0, delimiter.size());
    }
}