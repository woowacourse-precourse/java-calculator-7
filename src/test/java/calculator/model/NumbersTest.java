package calculator.model;

import calculator.model.exception.NotAllowedNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static calculator.common.message.ErrorMessage.LOWER_THAN_ZERO;
import static org.junit.jupiter.api.Assertions.*;

public class NumbersTest {

    @Test
    @DisplayName("음수 검증 시 throw NotAllowedNumberException")
    void doNotThrowExceptionWhenValidating() {
        // given
        List<Integer> source = List.of(1, 2, 3, 4, 5);
        // when
        // then
        assertDoesNotThrow(
                () -> Numbers.of(source)
        );
    }

    @Test
    @DisplayName("음수 검증 시 throw NotAllowedNumberException")
    void throwExceptionWhenValidateMinusNumber() {
        // given
        List<Integer> source = List.of(1, 2, 3, -4, 5);
        // when
        // then
        NotAllowedNumberException exception = assertThrowsExactly(
                NotAllowedNumberException.class,
                () -> Numbers.of(source)
        );
        assertEquals(LOWER_THAN_ZERO, exception.getMessage());
    }
}
