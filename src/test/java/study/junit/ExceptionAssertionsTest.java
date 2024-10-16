package study.junit;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit AssertJ 예외 Assertions 메서드")
class ExceptionAssertionsTest {

    @Test
    @DisplayName("예외 검증 테스트의 기본 패턴")
    void basicPattern() {
        assertThatThrownBy(() -> {
            throw new IllegalStateException("illegal state exception");
        }).isInstanceOf(IllegalStateException.class)
                .hasMessage("illegal %s exception", "state")
                .hasMessageContaining("exception");
    }

    @Test
    @DisplayName("자주 발생하는 예외: NullPointerException, Illegal(Argument/State)Exception, IOException")
    void assertThatExceptionOfType() {
        assertThatNullPointerException().isThrownBy(() -> {
                    throw new NullPointerException("null!");
                }).withMessage("%s!", "null")
                .withMessageContaining("null")
                .withNoCause();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            throw new IllegalArgumentException();
        });

        assertThatIOException().isThrownBy(() -> {
            throw new IOException();
        });
    }

    @Test
    @DisplayName("예외가 발생하지 않는 경우 검증")
    void noException() {
        assertThatNoException().isThrownBy(() -> System.out.println("No exception!"));

        assertThatCode(() -> System.out.println("No exception!")).doesNotThrowAnyException();
    }

}
