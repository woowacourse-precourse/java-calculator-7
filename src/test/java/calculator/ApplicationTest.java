package calculator;

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
            assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class);
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
            assertThatThrownBy(() -> runException(",,,,,,")).isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1,3,"));
        });
    }

    @Test
    void validateOnlyContainSEMICOLON() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(";;;;;;;;")).isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1;;3"));
        });
    }

    @Test
    void validateOnlyContainCOMMA_SEMICOLON() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",,,,,,;;;;;;;;")).isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> run("1;3,1"));
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
            assertThatThrownBy(() -> runException("0,2;3")).isInstanceOf(IllegalArgumentException.class);
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
                    .hasMessage("피연산자에 숫자가 아닌 다른 문자가 있습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1 000;1,55")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("피연산자에 숫자가 아닌 다른 문자가 있습니다");
        });
    }

    @Test
    void addInputOverIntegerSize() {
        assertSimpleTest(() -> {
            run("2147483648;");
            assertThat(output()).contains("결과 : 2147483648");
        });

        assertSimpleTest(() -> {
            run("2147483649 ;");
            assertThat(output()).contains("결과 : 2147483649");
        });
    }

    @Test
    void addInputOverLongSize() {
        assertSimpleTest(() -> {
            run("9223372036854775808;");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
    }

    @Test
    void validateResultOverIntSize() {
        assertSimpleTest(() -> {
            run("2147483647;1");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void validateResultOverLongSize() {
        assertSimpleTest(() -> {
            run("9223372036854775807;1");
            assertThat(output()).contains("결과 : 9223372036854775808");
        });
    }

    @Test
    void validateInputOnlyContaining_CustomDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n"))
                    .isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀 구분자 이후로 수식이 없습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!\\n "))
                    .isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀 구분자 이후로 수식이 없습니다");
        });
    }

    @Test
    void validateOverTwoCustomDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!\\n33??")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자가 2개이상 있습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!  \\n33??")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자가 2개이상 있습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//??\\n//!!  \\n//!1231  \\n33??")).isInstanceOf(
                            IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자가 2개이상 있습니다");
        });
    }

    @Test
    void validateContaining_OtherCharInFrontDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("~~~//??\\n33")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자의 형식인 //로 시작하지 않습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("     //??\\n33")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("커스텀 구분자의 형식인 //로 시작하지 않습니다");
        });
    }

    @Test
    void validateCustomDelimiterIsNumber() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//3\\n11394")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("구분자에 숫자가 들어있습니다");
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
            run("//!!!\\n12!!!345!!!-1");
            assertThat(output()).contains("결과 : 356");
        });
        assertSimpleTest(() -> {
            run("//!!!\\n12!!!0!!!-1");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void validateCustomDelimiterExpressionOnlyContaining_Positive_Delimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//?\\n33kk3333?")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("피연산자에 커스텀 구분자가 아닌 문자가 있습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//kk?\\n33kk?3333?")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("피연산자에 커스텀 구분자가 아닌 문자가 있습니다");
        });
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//???\\n33?3333")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("피연산자에 커스텀 구분자가 아닌 문자가 있습니다");
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
    void addInputOverIntegerSize_CustomDelimiter(){
        assertSimpleTest(()->{
            run("//?\\n2147483648");
            assertThat(output()).contains("결과 : 2147483648");
        });
    }

    @Test
    void addInputOverLongSize_CustomDelimiter(){
        assertSimpleTest(()->{
            run("//?\\n9223372036854775808");
            assertThat(output()).contains("결과 : 9223372036854775808");
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
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
