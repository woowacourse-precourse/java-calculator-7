package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DelimiterManagerTest {

    private final DelimiterManager delimiterManager = new DelimiterManager();

    @Test
    void 커스텀_구분자_등록() {
        delimiterManager.registerCustomDelimiter(";");
        Assertions.assertThat(delimiterManager.isValidDelimiter(";")).isTrue();
    }

}