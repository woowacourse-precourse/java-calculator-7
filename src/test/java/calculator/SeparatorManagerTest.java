package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import calculator.util.SeparatorManager;
import org.junit.jupiter.api.Test;

class SeparatorManagerTest {
    SeparatorManager separatorManager = new SeparatorManager();

    @Test
    void 이미_있는_구분자라면_예외_처리() {
        assertThatThrownBy(() -> separatorManager.add(":"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 없는_구분자라면_정상_작동() {
        assertThatCode(() -> separatorManager.add(";"))
                .doesNotThrowAnyException();
    }

    @Test
    void 받은_구분자_리스트의_수정_불가한지_확인() {
        assertThatThrownBy(() -> separatorManager.getSeparators().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}