package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomInputTest {

    @Test
    void 개행문자로_끝나지_않아서_실패() {
        assertThrows(IllegalArgumentException.class, () -> new Input("//a2a"));
    }

    @Test
    void 커스텀할때_구분자가_커스텀과_기본_동시에_제대로_받는지_확인() {
        Input input = new Input("//a\\n23a1");
        assertEquals(",|:|a", input.getSplitter());
        assertEquals("23a1", input.getStr());
    }

    @Test
    void 메타문자포함_성공() {
        Input input = new Input("//?\\n1?2?3:4");
        assertEquals(",|:|\\?", input.getSplitter());
        assertEquals("1?2?3:4", input.getStr());
    }

    @Test
    void 커스텀여러개_성공() {
        Input input = new Input("//?\\n//a\\n1?2?3a4");
        assertEquals(",|:|\\?|a", input.getSplitter());
        assertEquals("1?2?3a4", input.getStr());
    }

    @Test
    void 커스텀문자가_하나가아니고_한번에_여러개_성공() {
        Input input = new Input("//?a\\n//a\\n1?2?a3a4");
        assertEquals(",|:|\\?a|a", input.getSplitter());
        assertEquals("1?2?a3a4", input.getStr());
    }
}
