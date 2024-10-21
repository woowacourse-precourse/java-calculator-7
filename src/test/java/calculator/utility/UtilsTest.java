package calculator.utility;

import calculator.domain.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class UtilsTest {
    @DisplayName("간단한 소수 확인_소수점 좌측 숫자 아닐 시 예외처리")
    @Test
    void simpleCheckLeftOfDecimal(){
        Delimiter delimiter = new Delimiter();
        assertThatThrownBy(() -> Utils.checkAllowedDelimiters("1,.23", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("간단한 소수 확인_소수점 우측 숫자 아닐 시 예외처리")
    @Test
    void simpleCheckRightOfDecimal(){
        Delimiter delimiter = new Delimiter();
        assertThatThrownBy(() -> Utils.checkAllowedDelimiters("123.,", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("설정 구분자 이외 문자 예외처리")
    @Test
    void checkInvalidDelimiters(){
        Delimiter delimiter = new Delimiter();
        assertThatThrownBy(() -> Utils.checkAllowedDelimiters("1;2,3", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("정상값 입력 시 정상 동작 확인")
    @Test
    void checkCompletion1(){
        Delimiter delimiter = new Delimiter();
        assertDoesNotThrow(() -> Utils.checkAllowedDelimiters("1,2,3", delimiter));
    }
    @DisplayName("정상값 입력 시 정상 동작 확인")
    @Test
    void checkCompletion2(){
        Delimiter delimiter = new Delimiter();
        assertDoesNotThrow(() -> Utils.checkAllowedDelimiters("1:2:3", delimiter));
    }
    @DisplayName("정상값 입력 시 정상 동작 확인")
    @Test
    void checkCompletion3(){
        Delimiter delimiter = new Delimiter();
        assertDoesNotThrow(() -> Utils.checkAllowedDelimiters("1.1,2.2,3.3", delimiter));
    }


    @DisplayName("숫자 확인")
    @Test
    void checkNum(){
        assertThat(Utils.checkNumber('3')).isEqualTo(true);
    }
    @DisplayName("숫자 확인")
    @Test
    void checkChar(){
        assertThat(Utils.checkNumber('e')).isEqualTo(false);
    }
}
