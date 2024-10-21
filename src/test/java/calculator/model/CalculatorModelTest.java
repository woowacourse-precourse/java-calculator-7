package calculator.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorModelTest {

    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1,2;3", "//\\n1,2,3,4"})
    void 커스텀_구분자_지정_문자_올바른_사용(String input) {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomDiscrimination(input)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;1,2:3", ";\\n1,2,3;4"})
    void 커스텀_구분자_지정_문자_사용_예외(String input) {
        CalculatorModel cm = new CalculatorModel();
        assertThatThrownBy(() -> cm.CustomDiscrimination(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "n1,2;3", " 1,2,3,4"})
    void 커스텀_구분자_지정_X(String input) {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomDiscrimination(input)).isEqualTo(false);
    }

    @Test
    void 커스텀_구분자_지정_추출_O() {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomExtraction("//;\\n1,2;3")).isEqualTo(";");
    }

    @Test
    void 커스텀_구분자_지정_빈값_추출() {
        CalculatorModel cm = new CalculatorModel();
        Assertions.assertThat(cm.CustomExtraction("//\\n1,2;3")).isEqualTo("");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\\n1,2,3", "//ad-\\n1,2,3"})
    void 커스텀_구분자_지정_예외처리(String input) {
        CalculatorModel cm = new CalculatorModel();
        assertThatThrownBy(() -> cm.CustomExtraction(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_연산_올바른_분리() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":"));
        Assertions.assertThat(cm.operationSetting("1,2:3", arrayList)).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 문자열_연산_올바른_분리_2() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":", ";"));
        Assertions.assertThat(cm.operationSetting("1,2:3;4", arrayList)).isEqualTo(new String[]{"1", "2", "3", "4"});
    }

    @Test
    void 문자열_연산_올바른_분리_3() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":", ";"));
        Assertions.assertThat(cm.operationSetting("1,2:3;a4", arrayList)).isEqualTo(new String[]{"1", "2", "3", "a4"});
    }

    @Test
    void 분리된_문자열_정상_연산() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":", ";"));
        Assertions.assertThat(cm.sumCalculator("1,2:3;4", arrayList)).isEqualTo(10);
    }

    @Test
    void 분리된_문자열_정상_연산_2() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":", ";"));
        Assertions.assertThat(cm.sumCalculator("1,2:;4", arrayList)).isEqualTo(7);
    }

    @Test
    void 분리된_문자열_연산_예외처리() {
        CalculatorModel cm = new CalculatorModel();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(",", ":", ";"));
        assertThatThrownBy(() -> cm.sumCalculator("1,2:3;a4", arrayList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}