package calculator.domain;

import calculator.util.RandomSupport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import static calculator.util.TestEnvironment.REPEATED_TEST_COUNT;
import static org.junit.jupiter.api.Assertions.assertAll;

class NumberTest extends RandomSupport {

    @Nested
    class 올바른_매개변수는 {
        @RepeatedTest(REPEATED_TEST_COUNT)
        void 기본_생성자_생성에_성공할_것이다() {
            final var result = new Number(randomPositive);
            assertAll(
                () -> Assertions.assertThat(result.value()).isEqualTo(randomPositive),
                () -> Assertions.assertThat(result.value()).isGreaterThan(0)
            );
        }

        @RepeatedTest(REPEATED_TEST_COUNT)
        void 정적_생성자_생성에_성공할_것이다() {
            final var result = Number.of(randomPositive);
            assertAll(
                () -> Assertions.assertThat(result.value()).isEqualTo(randomPositive),
                () -> Assertions.assertThat(result.value()).isGreaterThan(0)
            );
        }
    }

    @Nested
    class 올바르지_않은_매개변수는 {
        @RepeatedTest(REPEATED_TEST_COUNT)
        void 기본_생성자_생성에_예외가_발생할_것이다() {
            Assertions.assertThatThrownBy(() -> new Number(randomNegative))
                .isInstanceOf(IllegalArgumentException.class);
        }

        @RepeatedTest(REPEATED_TEST_COUNT)
        void 정적_생성자_생성에_예외가_발생할_것이다() {
            Assertions.assertThatThrownBy(() -> Number.of(randomNegative))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}