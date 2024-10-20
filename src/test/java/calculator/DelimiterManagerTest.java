package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterManagerTest {

    private final DelimiterManager delimiterManager = new DelimiterManager();

    @Test
    void 커스텀_구분자_등록() {
        delimiterManager.registerCustomDelimiter(";");
        assertThat(delimiterManager.isValidDelimiter(";")).isTrue();
    }

    @Test
    void 등록되지_않은_구분자_유효_테스트() {
        assertThat(delimiterManager.isValidDelimiter("%")).isFalse();
    }

}