package calculator;

import static calculator.service.exception.SeparationExceptionType.INVALID_SEPARATOR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.service.exception.SeparationException;
import calculator.service.separation.BasicSeparationService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    final String CUSTOM_SEPARATOR = "&";

    private final BasicSeparationService basicSeparationService = new BasicSeparationService();

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    // 커스텀
    @Test
    void 커스텀_구분자_사용_형식이_잘못된_경우() {
        String input = "//&\\s1&2&3";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            // 커스텀 구분자 형식이 잘못되었으므로 BasicSeparationService 사용
            basicSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(INVALID_SEPARATOR.message(), exception.getMessage());
    }
}
