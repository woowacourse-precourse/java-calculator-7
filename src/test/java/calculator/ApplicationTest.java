package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 숫자_하나만_입력되었을_때() {
        assertEquals(1, StringAddCalculator.add("1"));
    }

    @Test
    void 빈_문자열_테스트() {
        assertEquals(0, StringAddCalculator.add(""));
    }

    @Test
    void 쉼표_구분자로_숫자_덧셈_테스트() {
        assertEquals(6, StringAddCalculator.add("1,2,3"));
    }

    @Test 
    void 콜론_구분자로_숫자_덧셈_테스트() {
        assertEquals(6, StringAddCalculator.add("1:2:3"));
    }

    @Test
    void 쉼표_콜론_둘다() {
        assertEquals(6, StringAddCalculator.add("1,2:3"));
    }

    @Test
    void 음수_입력_시_오류발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.add("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    } 
    @Test
    void 음수가_두개_일때_오류발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.add("-1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -1, -2", exception.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
