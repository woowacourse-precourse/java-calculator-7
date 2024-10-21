package calculator.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultMessageTest {

    @Test
    void 출력형식() {
        final String message = "test";
        final ResultMessage resultMessage = new ResultMessage(message);

        Assertions.assertThat(resultMessage.getResult()).isEqualTo("결과 : " + message);
    }
}