package calculator.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeilimitersTest {
    @Test
    void 구분자_조회() {
        Delimiters delimiters = Delimiters.create();
        List<String> allDelimiters = delimiters.getAllDelimiters();
        Assertions.assertEquals(DefaultDelimiter.values().length, allDelimiters.size());
        Assertions.assertTrue(allDelimiters.contains(DefaultDelimiter.COLON.getSymbol()));
        Assertions.assertTrue(allDelimiters.contains(DefaultDelimiter.COMMA.getSymbol()));
    }

    @Test
    void 커스텀구분자_포함_구분자_조회() {
        String customDelimiter = "&";
        Delimiters delimiters = Delimiters.createWithCustomDelimiter(customDelimiter);
        List<String> allDelimiters = delimiters.getAllDelimiters();
        Assertions.assertEquals(DefaultDelimiter.values().length + 1, allDelimiters.size());
        Assertions.assertTrue(allDelimiters.contains(DefaultDelimiter.COLON.getSymbol()));
        Assertions.assertTrue(allDelimiters.contains(DefaultDelimiter.COMMA.getSymbol()));
        Assertions.assertTrue(allDelimiters.contains(customDelimiter));
    }
}