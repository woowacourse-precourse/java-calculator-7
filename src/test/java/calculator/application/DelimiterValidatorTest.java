package calculator.application;

import calculator.util.RandomSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import static calculator.util.TestEnvironment.REPEATED_TEST_COUNT;
import static org.junit.jupiter.api.Assertions.assertAll;

class DelimiterValidatorTest extends RandomSupport {

    private static final DelimiterValidator DELIMITER_VALIDATOR = new DelimiterValidator();

    @Nested
    class 마지막_문자_검증 {
        @RepeatedTest(REPEATED_TEST_COUNT)
        void 숫자는_예외가_발생하지_않을_것이다() {
            Assertions.assertThatCode(() -> DELIMITER_VALIDATOR.validLastCharacter(String.valueOf(createPositive())))
                .doesNotThrowAnyException();
        }

        @RepeatedTest(REPEATED_TEST_COUNT)
        void 숫자가_아니라면_예외가_발생할_것이다() {
            assertAll(
                () -> Assertions.assertThatThrownBy(() -> DELIMITER_VALIDATOR.validLastCharacter(createUpperAlphabetWord()))
                    .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> DELIMITER_VALIDATOR.validLastCharacter(createLowerAlphabetWord()))
                    .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> DELIMITER_VALIDATOR.validLastCharacter(createKorean()))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class 커스텀_구분자_검증 {
        @RepeatedTest(REPEATED_TEST_COUNT)
        void 하이픈이_아니라면_예외가_발생하지_않을_것이다() {
            Assertions.assertThatCode(() -> DELIMITER_VALIDATOR.validCustomDelimiter(new String[]{createLowerAlphabetWord()}))
                .doesNotThrowAnyException();
        }

        @RepeatedTest(REPEATED_TEST_COUNT)
        void 하이픈이라면_예외가_발생할_것이다() {
            assertAll(
                () -> Assertions.assertThatThrownBy(() -> DELIMITER_VALIDATOR.validCustomDelimiter(new String[]{"-"}))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Nested
    class 커스텀_구분자_사이즈 {
        @RepeatedTest(REPEATED_TEST_COUNT)
        void 구분자_갯수가_하나라면_예외가_발생하지_않을_것이다() {
            Assertions.assertThatCode(() -> DELIMITER_VALIDATOR.validCustomDelimiterSize(new String[1]))
                .doesNotThrowAnyException();
        }

        @RepeatedTest(REPEATED_TEST_COUNT)
        void 구분자_갯수가_하나가_아니라면_예외가_발생할_것이다() {
            assertAll(
                () -> Assertions.assertThatThrownBy(() -> DELIMITER_VALIDATOR.validCustomDelimiterSize(new String[createLoopCount() + 1]))
                    .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}