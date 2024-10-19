package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    Application application = new Application();

    // 테스트 케이스: 정상 입력으로 숫자 합 구하기
    @Test
    public void testValidInput() {
        assertEquals(6, application.calculate("1,2:3")); // 1 + 2 + 3 = 6
    }

    // 테스트 케이스: 커스텀 구분자 적용
    @Test
    public void testCustomDelimiter() {
        assertEquals(6, application.calculate("//;\\n1;2;3")); // 1 + 2 + 3 = 6
    }

    // 테스트 케이스: 숫자가 아닌 값이 포함될 때 예외 처리 확인
    @Test
    public void testInvalidCharacterInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            application.calculate("1,abc,3");
        });
        assertEquals("올바른 형식으로 입력해주세요.", exception.getMessage());
    }

    // 테스트 케이스: 빈 문자열 입력 시 예외 처리 확인
    @Test
    public void testEmptyInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            application.calculate("");
        });
        assertEquals("입력 값이 비어있습니다.", exception.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
