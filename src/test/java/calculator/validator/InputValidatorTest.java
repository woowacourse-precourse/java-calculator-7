package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
}