package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    static ArrayList<String> testDelimiterArr;
    static ArrayList<Integer> testExtractedNumbers;
    static ArrayDeque<String> testSplitNumbers;

    void calculatorConstructor(){
        testDelimiterArr = new ArrayList<>();
        testDelimiterArr.addAll(Arrays.asList(":",",",";","m45i","!"));

        testSplitNumbers = new ArrayDeque<>();
        testSplitNumbers.addAll(Arrays.asList("", "1", "", "34", "6567", "243", "989", "3"));

        testExtractedNumbers = new ArrayList<>();
        testExtractedNumbers.addAll(Arrays.asList(1,34,6567,243,989,3));
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 다수의_커스텀_구분자_추출() {
        calculatorConstructor();
        // given
        String testDelimiterText = "//;\\n1//m45i\\n//!\\n";

        // when
        Application.StringCalculator stringCalculator = new Application.StringCalculator();
        ArrayList<String> result = stringCalculator.extractDelimiter(testDelimiterText);

        // then
        assertThat(result).isEqualTo(testDelimiterArr);
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정의되지_않은_구분자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("‘3’4:93"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // splitNumbers()
    @Test
    void 숫자_문자_추출(){
        calculatorConstructor();
        String input = "//;\\n1//m45i\\n//!\\n34:6567;243m45i989!3";

        Application.StringCalculator stringCalculator= new Application.StringCalculator();
        stringCalculator.extractDelimiter(input);
        assertThat(stringCalculator.splitNumbers(input)).containsExactlyElementsOf(testSplitNumbers);
    }

    // isValidString()
    @Test
    void 유효_문자_검증(){
        ArrayDeque<String> testSplitque = new ArrayDeque<>();
        testSplitque.addAll(List.of("","3","4","","93"));

        Application.StringCalculator stringCalculator= new Application.StringCalculator();
        assertThat(stringCalculator.isValidString(testSplitque)).isTrue();
    }


    // ex. Custom(1) Number(2) Delimiter(1) : //;\n1;34
    // => Custom1_Number2_Delimiter1
    @Test
    void Custom0_Number0_Delimiter0() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Custom0_Number1_Delimiter0() {
        assertSimpleTest(() -> {
            run("3492");
            assertThat(output()).contains("결과 : 3492");
        });
    }

    @Test
    void Custom0_Number2_Delimiter2() {
        assertSimpleTest(() -> {
            run("3:4,93");
            assertThat(output()).contains("결과 : 100");
        });
    }


    @Test
    void Custom0_Number0_Delimiter2() {
        assertSimpleTest(() -> {
            run("3:4,93");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Test
    void Custom1_Number0_Delimiter0() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Custom1_Number1_Delimiter0() {
        assertSimpleTest(() -> {
            run("//;\\n34");
            assertThat(output()).contains("결과 : 34");
        });
    }

    @Test
    void Custom1_Number2_Delimiter1() {
        assertSimpleTest(() -> {
            run("//;\\n3;4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void Custom1_Number0_Delimiter2() {
        assertSimpleTest(() -> {
            run("//;\\n;;:");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Custom2_Number0_Delimiter0() {
        assertSimpleTest(() -> {
            run("//;\\n//'\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void Custom2_Number3_Delimiter3() {
        assertSimpleTest(() -> {
            run("//;\\n//’\\n3;4’93:");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Test
    void CustomString_Number1_Delimiter3() {
        assertSimpleTest(() -> {
            run("//;mz\\n//’34\\n’34;mz93");
            assertThat(output()).contains("결과 : 93");
        });
    }

    @Test
    void CustomEscape_Number3_Delimiter2() {
        assertSimpleTest(() -> {
            run("//;\\n//\\t\\n3\\t4;93");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Test
    void Custom2_NumberBetween_Delimiter1() {
        assertSimpleTest(() -> {
            run("//;\\n3:4//’\\n93");
            assertThat(output()).contains("결과 : 100");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
