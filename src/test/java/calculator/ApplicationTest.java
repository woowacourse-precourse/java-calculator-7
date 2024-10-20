package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//'\\n1", "//\"\\n1", "//,\\n1", "//;\\n1", "//:\\n1", "//-\\n1", "//.\\n1", "//*\\n1", "//_\\n1",
            "//+\\n1", "//?\\n1", "//[\\n1", "//]\\n1", "//{\\n1", "//}\\n1"
            , "//(\\n1", "//)\\n1", "//|\\n1", "//^\\n1", "//$\\n1", "//!\\n1", "//@\\n1", "//#\\n1", "//&\\n1", "//`\\n1",
            "//~\\n1", "//<\\n1", "//>\\n1", "///\\n1", "//\\\\n1"
    })
    void 커스텀_구분자_양수와_단독_사용(String input) throws Exception {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest
    @MethodSource("customDelimiterInputs")
    void 구분자_3개_양수와_사용(String input) throws Exception {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    static Stream<String> customDelimiterInputs() {
        return Stream.of(
                "//'\\n1'2'3",
                "//\"\\n1\"2\"3",
                "//,\\n1,2,3",
                "//;\\n1;2;3",
                "//:\\n1:2:3",
                "//-\\n1-2-3",
                "//.\\n1.2.3",
                "//*\\n1*2*3",
                "//_\\n1_2_3",
                "//+\\n1+2+3", "//?\\n1?2?3", "//[\\n1[2[3", "//]\\n1]2]3", "//{\\n1{2{3", "//}\\n1}2}3"
                , "//(\\n1(2(3", "//)\\n1)2)3", "//|\\n1|2|3", "//^\\n1^2^3", "//$\\n1$2$3", "//!\\n1!2!3", "//@\\n1@2@3",
                "//#\\n1#2#3",
                "//&\\n1&2&3", "//`\\n1`2`3",
                "//~\\n1~2~3", "//<\\n1<2<3", "//>\\n1>2>3", "///\\n1/2/3", "//\\\\n1\\2\\3"
        );
    }

    @ParameterizedTest
    @MethodSource("customDelimiterWithNegativeQNumberInputs")
    void 구분자_음수_사용(String input) throws Exception {
        assertSimpleTest(() -> {
           assertThatThrownBy(() -> run(input))
                   .isInstanceOf(IllegalArgumentException.class);
        });
    }

    static Stream<String> customDelimiterWithNegativeQNumberInputs() {
        return Stream.of(
                "//'\\n1'-2'3",
                "//\"\\n1\"-2\"3",
                "//,\\n1,-2,3",
                "//;\\n1;-2;3",
                "//:\\n1:-2:3",
                "//.\\n1.-2.3",
                "//*\\n1*-2*3",
                "//_\\n1_-2_3",
                "//+\\n1+-2+3", "//?\\n1?-2?3", "//[\\n1[-2[3", "//]\\n1]-2]3", "//{\\n1{-2{3", "//}\\n1}-2}3"
                ,"//(\\n1(-2(3", "//)\\n1)-2)3", "//|\\n1|-2|3", "//^\\n1^-2^3", "//$\\n1$-2$3", "//!\\n1!-2!3",
                "//@\\n1@-2@3",
                "//#\\n1#-2#3",
                "//&\\n1&-&3", "//`\\n1`-2`3",
                "//~\\n1~-2~3", "//<\\n1<-2<3", "//>\\n1>-2>3", "///\\n1/-2/3", "//\\\\n1\\-2\\3",
                "//-\\n1--2-3"
        );
    }
}
