package calculator.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeilimitersTest {

    @Test
    void 구분자_조회() {
        Delimiters delimiters = Delimiters.create();
        List<String> allDelimiters = delimiters.getAllDelimiters();
        Assertions.assertEquals(Delimiter.values().length, allDelimiters.size());
        Assertions.assertTrue(allDelimiters.contains(Delimiter.COLON.getSymbol()));
        Assertions.assertTrue(allDelimiters.contains(Delimiter.COMMA.getSymbol()));
    }
}