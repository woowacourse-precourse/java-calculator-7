package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.DefaultDelimiter;
import calculator.model.RegularExpression;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

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
    void getDefaultDelimiters_CommaAndColon_EqualTwoList() {
        assertSimpleTest(() -> {
            List<String> expectedDelimiter = List.of(":", ",");
            List<String> resultDelimiter = DefaultDelimiter.getDefaultDelimiters();
            if (!expectedDelimiter.equals(resultDelimiter)) {
                throw new Exception("기본 구분자가 다릅니다!");
            }
        });
    }

    @Test
    void validateCustomLineFormat_InvalidCustomLineFormat_ExceptionThrown() {
        assertSimpleTest(() -> {
            String input = "//[\\1[2[3";
            Pattern pattern = Pattern.compile(RegularExpression.CUSTOM_LINE.getRegularExpression());
            Matcher matcher = pattern.matcher(input);
            try {
                ValidationUtils.validateCustomLineFormat(matcher);
                throw new Exception("예외가 발생하지 않았습니다.");
            } catch (IllegalArgumentException e) {
                return;
            }
        });
    }

    @Test
    void validateCustomLineFormat_InputNumericCharacter_ExceptionThrown() {
        assertSimpleTest(() -> {
            String input = "//1\\\\1,2,3";
            Pattern pattern = Pattern.compile(RegularExpression.CUSTOM_LINE.getRegularExpression());
            Matcher matcher = pattern.matcher(input);

            try {
                ValidationUtils.validateCustomLineFormat(matcher);
                throw new Exception("예외가 발생하지 않았습니다.");
            } catch (IllegalArgumentException e) {
                return;
            }
        });
    }

    @Test
    void validateCustomLineFormat_InputDuplicatedCharacter_ExceptionThrown() {
        assertSimpleTest(() -> {
            String input = "//;;\\\\n1[2[3";
            Pattern pattern = Pattern.compile(RegularExpression.CUSTOM_LINE.getRegularExpression());
            Matcher matcher = pattern.matcher(input);

            try {
                ValidationUtils.validateCustomLineFormat(matcher);
                throw new Exception("예외가 발생하지 않았습니다.");
            } catch (IllegalArgumentException e) {
                return;
            }
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
