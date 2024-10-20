package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegDelimiterTest {

    /**
     * Deprecated
     * private 메서드의 테스트 코드로 주석 처리함.
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

    @DisplayName("예약어가 포함된 커스텀 구분자 입력 시 예외를 발생시킨다.")
    @Test
    void fail_IfCustomDelimiterContainsRegisteredWords() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString1 = "//%//";
        String testString2 = "//-";

        assertThatThrownBy(() -> regDelimiter.registerCustomDelimiter(testString1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> regDelimiter.registerCustomDelimiter(testString2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 종료 문자를 입력하지 않으면 예외를 발생시킨다.")
    @Test
    void fail_IfCustomDeliEndSignalNotExists() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%%1%2,3";

        assertThatThrownBy(() -> regDelimiter.registerCustomDelimiter(testString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자 문자열이 종료되는 인덱스가 저장된다.")
    @Test
    void getCustomDeliEndIndex_WhenInputCustomDelimiter() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%%\\n1%%2,3";

        regDelimiter.registerCustomDelimiter(testString);

        assertThat(regDelimiter.getCustomDeliEndIdx()).isEqualTo(5);
    }

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자가 등록된 구분자 목록에 저장된다.")
    @Test
    void registerCustomDeli_WhenInputCustomDelimiter_1() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%$\\n1%2,3";

        regDelimiter.registerCustomDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(5);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%$");
    }

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자가 등록된 구분자 목록에 저장된다.")
    @Test
    void registerCustomDeli_WhenInputCustomDelimiter_2() {
        RegDelimiter regDelimiter = new RegDelimiter();
        String testString = "//%\\n1%2,3";

        regDelimiter.registerCustomDelimiter(testString);

        int customDeliEndIdx = regDelimiter.getCustomDeliEndIdx();
        List<String> delimiters = regDelimiter.getDelimiters();

        assertThat(customDeliEndIdx).isEqualTo(4);
        assertThat(delimiters.size()).isEqualTo(3);
        assertThat(delimiters.get(0)).isEqualTo(",");
        assertThat(delimiters.get(1)).isEqualTo(":");
        assertThat(delimiters.get(2)).isEqualTo("%");
    }
}
