package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @Nested
    @DisplayName("기본 구분자 입력값 테스트")
    class DefaultInputTest {

        @Test
        void 기본_구분자가_컴마_로만_이루어지면_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate("1,2,3"));
        }

        @Test
        void 기본_구분자가_콜론_으로만_이루어지면_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate("1:2:3"));
        }

        @Test
        void 기본_구분자가_컴마_와_콜론으로_이루어지면_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate("1,2:3"));
        }
    }

    @Nested
    @DisplayName("커스텀 구분자 입력값 테스트")
    class CustomInputTest {

        @Test
        void 커스텀_구분자가_존재하지_않으면_예외를_발생한다() {
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validate("//\\n1,2,3"));
        }

        @Test
        void 커스텀_구분자가_존재하지만_커스텀_구분자와_숫자가_존재하지_않으면_예외를_발생한다() {
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validate("//;\\n"));
        }

        @Test
        void 커스텀_구분자가_존재하지만_커스텀_구분자가_숫자로_이루어져_있으면_예외를_발생한다() {
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validate("//1\\n1,2,3"));
        }

        @Test
        void 커스텀_구분자가_한_자리_인경우_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate("//;\\n1;2;3"));
            assertDoesNotThrow(() -> inputValidator.validate("//%\\n1%2%3"));
        }

        @Test
        void 커스텀_구분자가_두_자리_이상일_때도_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate("//;;\\n1;;2;;3"));
            assertDoesNotThrow(() -> inputValidator.validate("//;%\\n1;%2;%3"));
        }
    }

    @Nested
    @DisplayName("기타 예외 상황 테스트")
    class ExceptionTest {

        @Test
        void 빈_문자열이_입력은_테스트를_통과한다() {
            assertDoesNotThrow(() -> inputValidator.validate(""));
        }

        @Test
        void 숫자가_아닌_문자가_입력되면_예외를_발생한다() {
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validate("1,a,3"));
        }

        @Test
        void 음수가_입력되면_예외를_발생한다() {
            assertThrows(IllegalArgumentException.class, () -> inputValidator.validate("-1,2,3"));
        }
    }
}