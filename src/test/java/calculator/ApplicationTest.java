package calculator;

import static calculator.ErrorMessages.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void validateEmptyInput() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
        assertSimpleTest(() -> {
            run("23;");
            assertThat(output()).contains("결과 : 23");
        });
    }

    @Test
    void validateNoDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_NOT_CONTAIN_DELIMITER);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123;123"));
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123,123"));
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123;12,3"));
        });
    }

    @Test
    void validateOnlyContainCOMMA() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",,,,,,")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("," + ERROR_BASIC_DELIMITER_ONLY_DELIMITER_SUPPORT);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1,3,"));
        });
    }

    @Test
    void validateOnlyContainSEMICOLON() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(";;;;;;;;")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(";" + ERROR_BASIC_DELIMITER_ONLY_DELIMITER_SUPPORT);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1;;3"));
        });
    }

    @Test
    void validateOnlyContainCOMMA_SEMICOLON() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",,,,,,;;;;;;;;")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(",|;" + ERROR_BASIC_DELIMITER_ONLY_DELIMITER_SUPPORT);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1;3,1"));
        });
        assertSimpleTest(() -> {
            run("9223372036854775808;");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
        assertSimpleTest(() -> {
            run("9223372036854775807;1");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
    }

    @Test
    void addInputContainCOMMA() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("1,2,,,");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void addInputContainSEMICOLON() {
        assertSimpleTest(() -> {
            run("1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run("1;2;;;");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void addInputContainCOMMA_SEMICOLON() {
        assertSimpleTest(() -> {
            run("1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
        assertSimpleTest(() -> {
            run(";;1,2;;;");
            assertThat(output()).contains("결과 : 3");
        });
        assertSimpleTest(() -> {
            run(";1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void validateAddingNotContainZero() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("0,2;3")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_ZERO);
        });
    }

    @Test
    void addInput_ContainingSpace() {
        assertSimpleTest(() -> {
            run("1;2 ;3 ;4;5 ");
            assertThat(output()).contains("결과 : 15");
        });
        assertSimpleTest(() -> {
            run("1;2 ;3 ;4;  5 ");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void validateInput_ContainingPositive_Delimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(";,kk333333")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_OTHER_CHAR);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1 000;1,55")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_OTHER_CHAR);
        });
    }

    @Test
    void validateInputOnlyContaining_CustomDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_NO_EXPRESSION_CUSTOM_DELIMITER);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!\\n ")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_NO_EXPRESSION_CUSTOM_DELIMITER);
        });
    }

    @Test
    void validateOverTwoCustomDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!\\n33??")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_CUSTOM_DELIMITER_OVER_TWO);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!  \\n33??")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_CUSTOM_DELIMITER_OVER_TWO);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!  \\n//!1231  \\n33??")).isInstanceOf(IllegalArgumentException.class).
                    hasMessage(ERROR_CUSTOM_DELIMITER_OVER_TWO);
        });
    }

    @Test
    void validateContaining_OtherCharInFrontDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("~~~//??\\n33")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_CUSTOM_DELIMITER_NOT_START_WITH_FORMAT);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("     //??\\n33")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_CUSTOM_DELIMITER_NOT_START_WITH_FORMAT);
        });
    }

    @Test
    void validateCustomDelimiterIsNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//3\\n11394")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_CUSTOM_DELIMITER_CONTAIN_NUMBER);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("//dd\\n33"));
        });
    }

    @Test
    void addCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//?\\n12?345");
            assertThat(output()).contains("결과 : 357");
        });
        assertSimpleTest(() -> {
            run("//?\\n2147483647?1");
            assertThat(output()).contains("결과 : 2147483648");
        });
        assertSimpleTest(() -> {
            run("//?\\n9223372036854775807?1");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
    }

    @Test
    void validateCustomDelimiterNotContainZero() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//!!!\\n12!!!345!!!0 ")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_ZERO);
        });
    }

    @Test
    void validateCustomDelimiterNotContainMinus() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//!!!\\n12!!!345!!!-1")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_MINUS);
        });
    }

    @Test
    void validateCustomDelimiterExpressionOnlyContaining_Positive_Delimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//?\\n33kk3333?")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_OTHER_CHAR);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//kk?\\n33kk?3333?")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_OTHER_CHAR);
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//???\\n33?3333")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ERROR_OPERANDS_CONTAIN_OTHER_CHAR);
        });
    }

    @Test
    void addIfOperandContainsSpace() {
        assertSimpleTest(() -> {
            run("//?\\n1?2 ?3 ?4?5");
            assertThat(output()).contains("결과 : 15");
        });
        assertSimpleTest(() -> {
            run("//?\\n1?2 ?3 ?4?5?");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
