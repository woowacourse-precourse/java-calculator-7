package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

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
    void 숫자_문자_추출(){
        calculatorConstructor();
        String input = "//;\\n1//m45i\\n//!\\n34:6567;243m45i989!3";

        Application.StringCalculator stringCalculator= new Application.StringCalculator();
        stringCalculator.extractDelimiter(input);
        assertThat(stringCalculator.splitNumbers(input)).containsExactlyElementsOf(testSplitNumbers);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
