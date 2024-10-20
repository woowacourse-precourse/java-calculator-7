package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Message.Message.OUTPUT_MESSAGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest extends NsTest {

    @Test
    @DisplayName("아무 것도 입력되지 않는 케이스")
    void blankFormula() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains(OUTPUT_MESSAGE + "0");
        });
    }

    @Test
    @DisplayName("구분자만 입력되는 케이스")
    void onlySeparator() {
        assertSimpleTest(() -> {
            run(",,:,::");
            assertThat(output()).contains(OUTPUT_MESSAGE + "0");
        });
    }

    @Test
    @DisplayName("숫자만 입력되는 케이스")
    void onlyNumber() {
        assertSimpleTest(() -> {
            run("12345");
            assertThat(output()).contains(OUTPUT_MESSAGE + "12345");
        });
    }

    @Test
    @DisplayName("콤마 구분자만 존재하는 케이스")
    void onlyCommaSeparator() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5");
            assertThat(output()).contains(OUTPUT_MESSAGE + "15");
        });
    }

    @Test
    @DisplayName("콜론 구분자만 입력되는 케이스")
    void onlyColonSeparator() {
        assertSimpleTest(() -> {
            run("1:2:3:4:5");
            assertThat(output()).contains(OUTPUT_MESSAGE + "15");
        });
    }

    @Test
    @DisplayName("콤마, 콜론 구분자가 혼용되는 케이스")
    void commaAndColonSeparator() {
        System.out.println(output());
        assertSimpleTest(() -> {
            run("1,2:3,4:5");
            assertThat(output()).contains(OUTPUT_MESSAGE + "15");
        });
    }

    @Test
    @DisplayName("구분자가 연속해서 나오는 케이스")
    void againSeparator() {
        assertSimpleTest(() -> {
            run("1,2:,:4:5");
            assertThat(output()).contains(OUTPUT_MESSAGE + "12");
        });
    }

    @Test
    @DisplayName("구분자, 숫자가 아닌 값이 입력된 케이스")
    void noneSepAndNum() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2:3*4?5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
