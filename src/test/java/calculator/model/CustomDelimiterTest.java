package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomDelimiterTest {

    @DisplayName("예약어가 포함된 커스텀 구분자 입력 시 예외를 발생시킨다.")
    @Test
    void fail_IfCustomDelimiterContainsRegisteredWords() {
        CustomDelimiter customDelimiter = new CustomDelimiter();
        String testString = "//-";

        assertThatThrownBy(() -> customDelimiter.register(testString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자 종료 문자를 입력하지 않으면 예외를 발생시킨다.")
    @Test
    void fail_IfCustomDeliEndSignalNotExists() {
        CustomDelimiter customDelimiter = new CustomDelimiter();
        String testString = "//%%1%2,3";

        assertThatThrownBy(() -> customDelimiter.register(testString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("커스텀 구분자를 입력하면 커스텀 구분자 문자열이 종료되는 인덱스가 저장된다.")
    @Test
    void getCustomDeliEndIndex_WhenInputCustomDelimiter() {
        CustomDelimiter customDelimiter = new CustomDelimiter();
        String testString = "//%%\\n1%%2,3";

        customDelimiter.register(testString);

        assertThat(customDelimiter.getValueEndIdx()).isEqualTo(5);
    }


}
