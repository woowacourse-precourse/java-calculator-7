package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest extends NsTest {

    private final InputValidator inputValidator = new InputValidator();
    private final StringSplitter stringSplitter = new StringSplitter();

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
    void 입력_유효_테스트() {

        // 올바른 입력
        assertTrue(inputValidator.isValid("1,2"));
        assertTrue(inputValidator.isValid("//#\\n1:23,3#4"));
        assertTrue(inputValidator.isValid("//;\\n"));

        // 구분자가 숫자보다 먼저온 경우
        assertFalse(inputValidator.isValid(":123:12;2"));
        // 중간에 띄어쓰기가 들어간 경우
        assertFalse(inputValidator.isValid("//;\\n:12 3:12;2"));
        // 구분자가 맨 뒤에 오는 경우
        assertFalse(inputValidator.isValid("//;\\n123:12;2:"));
        // 커스텀 서식이 잘못되었을 경우
        assertFalse(inputValidator.isValid("/;\\n123:12;2:"));
        // 음수입력
        assertFalse(inputValidator.isValid("//;\\n123:-12;2"));

    }

    @Test
    void 문자열_나누기_테스트() {
        // 기본 및 커스텀 구분자 혼합 테스트
        List<Integer> result = stringSplitter.split("//;\\n1;234,3:4");
        assertEquals(List.of(1, 234, 3, 4), result);
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
