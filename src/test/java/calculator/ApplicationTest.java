package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

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
        assertEquals(6, StringAddCalculator.add("1:2:3"));
    }

    @Test
    void 음수_입력_시_오류발생() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.add("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    } 

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
