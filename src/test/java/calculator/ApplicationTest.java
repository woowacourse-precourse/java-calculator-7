package calculator;

import static calculator.service.exception.SeparationExceptionType.ENDS_WITH_SEPARATOR;
import static calculator.service.exception.SeparationExceptionType.INVALID_SEPARATOR;
import static calculator.service.exception.SeparationExceptionType.NOT_A_POSITIVE_NUMBER;
import static calculator.service.exception.SeparationExceptionType.STARTS_WITH_SEPARATOR;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.domain.Number;
import calculator.domain.Numbers;
import calculator.service.exception.SeparationException;
import calculator.service.separation.BasicSeparationService;
import calculator.service.separation.CustomSeparationService;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    final String CUSTOM_SEPARATOR = "&";
    final String BASIC_SEPARATOR_COMMA = ",";
    final String BASIC_SEPARATOR_COLON = ":";

    private final CustomSeparationService customSeparationService = new CustomSeparationService();
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

    @Test
    void 커스텀_구분자를_사용하고_입력값이_비어있는_경우() {
        String input = "//&\\n";
        Numbers numbers = Numbers.from(List.of(Number.from(0)));
        assertEquals(
                customSeparationService.getNumbers(input, CUSTOM_SEPARATOR),
                numbers
        );
    }

    @Test
    void 커스텀_구분자를_사용하고_입력값이_공백문자인_경우() {
        String input = "//&\\n     ";
        Numbers numbers = Numbers.from(List.of(Number.from(0)));
        assertEquals(
                customSeparationService.getNumbers(input, CUSTOM_SEPARATOR),
                numbers
        );
    }

    @Test
    void 커스텀_구분자를_사용하고_입력값이_커스텀_구분자로_시작하는_경우() {
        String input = "//&\\n&1&2&3";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            customSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(STARTS_WITH_SEPARATOR.message(), exception.getMessage());
    }

    @Test
    void 커스텀_구분자를_사용하고_입력값이_커스텀_구분자로_끝나는_경우() {
        String input = "//&\\n1&2&3&";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            customSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(ENDS_WITH_SEPARATOR.message(), exception.getMessage());
    }

    @Test
    void 커스텀_구분자를_사용하고_커스텀_구분자로_나뉘어진_모든_요소가_숫자가_아닌_경우() {
        String input = "//&\\n1&2&A";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            customSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(INVALID_SEPARATOR.message(), exception.getMessage());
    }

    @Test
    void 커스텀_구분자를_사용하고_커스텀_구분자로_나뉘어진_모든_요소가_양수가_아닌_경우() {
        String input = "//&\\n1&2&0";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            customSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(NOT_A_POSITIVE_NUMBER.message(), exception.getMessage());
    }

    @Test
    void 커스텀_구분자를_사용하고_지정된_커스텀_구분자를_사용하지_않는_경우() {
        String input = "//&\\n1&2*3";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            customSeparationService.getNumbers(input, CUSTOM_SEPARATOR);
        });
        assertEquals(INVALID_SEPARATOR.message(), exception.getMessage());
    }

    // 기본
    @Test
    void 기본_구분자를_사용하고_입력값이_비어있는_경우() {
        final String input = "";
        Numbers numbers = Numbers.from(List.of(Number.from(0)));
        assertEquals(
                basicSeparationService.getNumbers(input, BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON),
                numbers
        );
    }

    @Test
    void 기본_구분자를_사용하고_입력값이_공백문자인_경우() {
        final String input = "     ";
        Numbers numbers = Numbers.from(List.of(Number.from(0)));
        assertEquals(
                basicSeparationService.getNumbers(input, BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON),
                numbers
        );
    }

    @Test
    void 기본_구분자를_사용하고_입력값이_콤마로_시작하는_경우() {
        final String input = ",1,2:3";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            basicSeparationService.getNumbers(input, BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON);
        });
        assertEquals(STARTS_WITH_SEPARATOR.message(), exception.getMessage());
    }

    @Test
    void 기본_구분자를_사용하고_입력값이_콜론으로_시작하는_경우() {
        final String input = ":1,2:3";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            basicSeparationService.getNumbers(input, BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON);
        });
        assertEquals(STARTS_WITH_SEPARATOR.message(), exception.getMessage());
    }

    @Test
    void 기본_구분자를_사용하고_입력값이_콤마로_끝나는_경우() {
        final String input = "1,2:3,";
        SeparationException exception = assertThrows(SeparationException.class, () -> {
            basicSeparationService.getNumbers(input, BASIC_SEPARATOR_COMMA, BASIC_SEPARATOR_COLON);
        });
        assertEquals(ENDS_WITH_SEPARATOR.message(), exception.getMessage());
    }
}
