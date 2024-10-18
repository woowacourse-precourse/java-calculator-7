package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RegDelimiterTest {

    /**
     * Deprecated
     * 비즈니스 로직과 거리가 먼 메서드의 테스트 코드로 주석 처리함.
     */
//    @Test
//    void 커스텀_구분자_시작_문자_true_반환() {
//        //Given
//        RegDelimiter regDelimiter = new RegDelimiter();
//        String testString1 = "//%\\n1%2";
//        String testString2 = "//";
//
//        //When
//        boolean includesCustomDeli1 = regDelimiter.includesCustomDelimiter(testString1);
//        boolean includesCustomDeli2 = regDelimiter.includesCustomDelimiter(testString2);
//
//        //Then
//        assertThat(includesCustomDeli1).isTrue();
//        assertThat(includesCustomDeli2).isTrue();
//    }
//
//    @Test
//    void 커스텀_구분자가_시작_문자_없으면_false_반환() {
//        RegDelimiter regDelimiter = new RegDelimiter();
//        String testString = "1,2";
//
//        boolean includesCustomDeli = regDelimiter.includesCustomDelimiter(testString);
//
//        assertThat(includesCustomDeli).isFalse();
//    }

    @Test
    void 잘못된_커스텀_구분자_입력_시_예외_발생() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString1 = "//%//";
        String testString2 = "//-";

        assertThatThrownBy(() -> regDelimiter.registerDelimiter(testString1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> regDelimiter.registerDelimiter(testString2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_종료_문자_입력() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%%\\n1%%2,3";

        regDelimiter.registerDelimiter(testString);

        assertThat(regDelimiter.getCustomDeliEndIdx()).isEqualTo(5);
    }

    @Test
    void 커스텀_구분자_종료_문자_없으면_예외_발생() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%%1%2,3";

        assertThatThrownBy(() -> regDelimiter.registerDelimiter(testString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최종_커스텀_구분자_입력_성공_1() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%$\\n1%2,3";

        regDelimiter.registerDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(5);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%$");
    }

    @Test
    void 최종_커스텀_구분자_입력_성공_2() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%\\n1%2,3";

        regDelimiter.registerDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(4);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%");
    }
}
