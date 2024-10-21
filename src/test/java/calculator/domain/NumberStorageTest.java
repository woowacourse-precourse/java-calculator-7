package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberStorageTest {
    @DisplayName("0입력시 예외처리 확인")
    @Test
    void inputZero_Error1(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        assertThatThrownBy(() -> numberStorage.addNumber("0", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("소수 0입력시 예외처리 확인")
    @Test
    void inputZero_Error2(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        assertThatThrownBy(() -> numberStorage.addNumber("0.0", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("소수 정수 누락 시 예외처리 확인")
    @Test
    void checkMissingIntegerPart(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        assertThatThrownBy(() -> numberStorage.addNumber(".123", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("소수 정수 누락 시 예외처리 확인")
    @Test
    void checkMissingFractionalPart(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        assertThatThrownBy(() -> numberStorage.addNumber("123.", delimiter))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("정상 동작 시 결과값 확인_정수")
    @Test
    void checkTotalSumInteger(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        numberStorage.addNumber("1", delimiter);
        numberStorage.addNumber("2", delimiter);
        numberStorage.addNumber("3", delimiter);

        assertThat(numberStorage.getTotalSum()).isEqualTo(6.0);
    }
    @DisplayName("정상 동작 시 결과값 확인_소수")
    @Test
    void checkTotalSumDecimal(){
        NumberStorage numberStorage = new NumberStorage();
        Delimiter delimiter = new Delimiter();

        numberStorage.addNumber("1.1", delimiter);
        numberStorage.addNumber("2.2", delimiter);
        numberStorage.addNumber("3.3", delimiter);

        assertThat(numberStorage.getTotalSum()).isEqualTo(6.6);
    }
}
