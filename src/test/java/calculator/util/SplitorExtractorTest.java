package calculator.util;

import calculator.InputString;
import calculator.splitor.BasicSplitor;
import calculator.splitor.CustomSplitor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class SplitorExtractorTest {
    SplitorExtractor splitorExtractor = new SplitorExtractor();

    @DisplayName("문자열이 커스텀 구분자를 지정하고 있으면 CustomSplitor를 반환한다.")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("//;\\n1;3;4");
            assertThat(splitorExtractor.extractSplitor(inputString)).isInstanceOf(CustomSplitor.class);
        });
    }

    @DisplayName("문자열이 커스텀 구분자를 지정하고 있지 않으면 BasicSplitor를 반환한다.")
    @Test
    void test2() {
        assertSimpleTest(() -> {
            InputString inputString = new InputString("1;3;4");
            assertThat(splitorExtractor.extractSplitor(inputString)).isInstanceOf(BasicSplitor.class);
        });
    }
}