package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringHandlerTest {
    StringHandler handler = new StringHandler();
    SeparatorManager separatorManager = new SeparatorManager();

    @Test
    void 커스텀구분자만_리턴하는지_확인() {
        assertEquals("@",
                handler.extractSeparator("//@\n1@2@3"));
    }


    @Test
    void 숫자만_반환하는지_확인() {
        assertEquals(List.of("1", "2", "3"),
                handler.getNumbers(separatorManager.getSeparators(), "1:2,3"));
    }

    @Test
    void 커스텀_구분자_선언부분만_잘라내는지_확인() {
        assertEquals("1,2;3",
                handler.removeCustom("//;\n1,2;3"));
    }
}