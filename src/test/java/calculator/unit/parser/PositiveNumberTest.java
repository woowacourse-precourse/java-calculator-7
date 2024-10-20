package calculator.unit.parser;

import static calculator.parser.PositiveNumberExceptionMessage.NO_EMPTY;
import static calculator.parser.PositiveNumberExceptionMessage.NO_NEGATIVE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {
    private static final int ZERO = 0;
    private final int number;


    public PositiveNumberTest(Integer number) {
        validateEmpty(number);
        validatePositive(number);
        this.number = number;
    }

    public int getValue() {
        return this.number;
    }

    private void validateEmpty(Integer number) {
        if (isEmpty(number)) {
            throw new IllegalArgumentException(NO_EMPTY.getMessage());
        }
    }

    private void validatePositive(Integer number) {
        if (!isPositive(number)) {
            throw new IllegalArgumentException(NO_NEGATIVE.getMessage());
        }
    }

    private boolean isPositive(Integer number) {
        return number >= ZERO;
    }

    private boolean isEmpty(Integer number) {
        return number == null || number.equals("");
    }
}


class PositiveNumberMethodTest {

    @Nested
    @DisplayName("생성자 테스트")
    class ConstructorTest {

        @Test
        @DisplayName("양수 입력 시 객체 생성 성공")
        void constructor_ok_1() {
            int input = 1;
            assertThatCode(() -> new PositiveNumberTest(input))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("0 입력 시 객체 생성 성공")
        void constructor_ok_2() {
            int input = 0;
            assertThatCode(() -> new PositiveNumberTest(input))
                    .doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, -100})
        @DisplayName("음수 입력 시 예외 발생")
        void constructor_ok_3(int input) {
            assertThatThrownBy(() -> new PositiveNumberTest(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NO_NEGATIVE.getMessage());
        }

        @Test
        @DisplayName("null 입력 시 예외 발생")
        void constructor_ok_4() {
            assertThatThrownBy(() -> new PositiveNumberTest(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NO_EMPTY.getMessage());
        }
    }

    @Nested
    @DisplayName("getValue 메서드 테스트")
    class GetValueTest {

        @Test
        @DisplayName("입력한 값이 정확히 반환되는지 확인")
        void getValue_ok_1() {
            int input = 5;
            PositiveNumberTest positiveNumber = new PositiveNumberTest(input);
            assertThat(positiveNumber.getValue()).isEqualTo(input);
        }
    }

    @Nested
    @DisplayName("경계값 테스트")
    class BoundaryValueTest {

        @Test
        @DisplayName("최대 정수값 입력 시 객체 생성 성공")
        void boundary_1() {
            assertThatCode(() -> new PositiveNumberTest(Integer.MAX_VALUE))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("최소 정수값 입력 시 예외 발생")
        void boundary_2() {
            assertThatThrownBy(() -> new PositiveNumberTest(Integer.MIN_VALUE))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NO_NEGATIVE.getMessage());
        }
    }

}
