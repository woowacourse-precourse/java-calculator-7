package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
