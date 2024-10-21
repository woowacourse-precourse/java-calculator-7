package calculator.domain;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SeperatorTest {

    @Test
    void 구분자_한_글자_유효성_확인() {
        try {
            Separator s = new Separator("*&");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 구분자는 한 글자여야 합니다.", e.getMessage());
        }
    }

    @Test
    void 구분자_숫자_포함_입력_유효성_검사() {
        try {
            Separator s = new Separator("1");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 숫자는 구분자가 될 수 없습니다.", e.getMessage());
        }
    }
}
