package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
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

    @Test
    void 받은_구분자_리스트의_수정_불가한지_확인() {
        assertThatThrownBy(() -> separtorMananger.getSeparators().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}