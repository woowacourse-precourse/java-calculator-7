package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterTest {
    @Test
    public void 기본_생성_확인(){
        Delimiter delimiter = new BasicDelimiter();
        assertNotNull(delimiter);
    }
}