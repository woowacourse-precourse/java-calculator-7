package calculator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class SepartorManangerTest {
    SepartorMananger separtorMananger = new SepartorMananger();

    @Test
    void 이미_있는_구분자라면_True_반환() {
        assertTrue(separtorMananger.exists(":"));
    }

    @Test
    void 없는_구분자라면_False_반환() {
        assertFalse(separtorMananger.exists("!"));
    }

}