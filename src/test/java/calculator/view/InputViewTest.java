package calculator.view;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void 빈칸_입력_에러_처리() {
        try {
            InputView.validateContainSpace("1;2 ;4");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 문자열에 빈칸이 포함되어 있습니다.", e.getMessage());
        }
    }
}
