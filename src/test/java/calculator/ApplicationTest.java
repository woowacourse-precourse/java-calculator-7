package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        String input = "//;\n1;2;3";
        int result = Application.add(input);
        assertEquals(6, result);
    }

    @Test
    void 예외_테스트() {
        String input = "//;\n-1;2;3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Application.add(input);
        });

        assertEquals("음수를 입력할 수 없습니다.", exception.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}