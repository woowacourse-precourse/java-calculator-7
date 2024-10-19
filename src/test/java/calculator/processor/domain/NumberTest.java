package calculator.processor.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    void 양수로된숫자를파라미터로받는경우_해당수가저장된객체가생성된다() throws NoSuchFieldException, IllegalAccessException {
        // given
        Field numberField = Number.class.getDeclaredField("number");
        numberField.setAccessible(true);

        // when
        Number newNumber = new Number(1);

        // then
        Integer value = (Integer) numberField.get(newNumber);
        assertEquals(value, 1);
    }

    @Test
    void 음수가저장되는경우_예외가발생한다() {
        assertThatThrownBy(() -> new Number(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 더한값이정상적으로저장된다() throws NoSuchFieldException, IllegalAccessException {
        // given
        Field numberField = Number.class.getDeclaredField("number");
        numberField.setAccessible(true);
        Number number1 = new Number(1);
        Number number2 = new Number(2);

        // when
        Number newNumber = number1.plus(number2);
        Integer value = (Integer) numberField.get(newNumber);

        // then
        assertEquals(value, 3);
    }
}