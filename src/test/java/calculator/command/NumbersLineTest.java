package calculator.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumbersLineTest {
    @Test
    @DisplayName("숫자로 사용할 문자열을 저장할 수 있음")
    void test1() {
        String testValue = "1,2,3,4,5,6";

        NumbersLine result = new NumbersLine(testValue);

        assertThat(result.value()).isEqualTo(testValue);
        assertThat(result.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("문자도 상관없이 저장할 수 있음")
    void test2() {
        String testValue = "//a,b,\nc,d,eas";

        NumbersLine result = new NumbersLine(testValue);

        assertThat(result.value()).isEqualTo(testValue);
        assertThat(result.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("공백은 empty로 간주함")
    void test3() {
        String testValue = " ";

        NumbersLine result = new NumbersLine(testValue);

        assertThat(result.isEmpty()).isTrue();
        assertThrows(IllegalStateException.class, result::value);
    }

    @Test
    @DisplayName("null도 empty로 간주함")
    void test4() {
        String testValue = null;

        NumbersLine result = new NumbersLine(testValue);

        assertThat(result.isEmpty()).isTrue();
        assertThrows(IllegalStateException.class, result::value);
    }
}