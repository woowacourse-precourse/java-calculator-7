package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExtractorTest {

    @Test
    void 커스텀_구분자_추출하기() {
        Extractor extractor = new Extractor("//;\n1;2;3");
        Separator customSeparator = new Separator(";");
        assertEquals(customSeparator.getSeparator(), extractor.getCustomSeparators().get(0).getSeparator());
    }
}
