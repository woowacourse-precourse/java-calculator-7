package calculator.processor.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 빈문자열을입력되면_0이저장되어야한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        Field numbersField = Numbers.class.getDeclaredField("numbers");
        numbersField.setAccessible(true);
        String[] emptyArray = {""};

        // when
        Numbers numbers = new Numbers(emptyArray);

        // then
        @SuppressWarnings("unchecked")
        List<Number> values = (List<Number>) numbersField.get(numbers);
        assertEquals(values, List.of(Number.ZERO));
    }

    @Test
    void 문자열값들이들어오면_Number로_값들이저장되어야한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        Field numbersField = Numbers.class.getDeclaredField("numbers");
        numbersField.setAccessible(true);
        String[] numberArray = {"1", "2", "3"};

        // when
        Numbers numbers = new Numbers(numberArray);

        // then
        @SuppressWarnings("unchecked")
        List<Number> values = (List<Number>) numbersField.get(numbers);
        assertEquals(values, List.of(new Number(1), new Number(2), new Number(3)));
    }

    @Test
    void sum_문자들의합을정상적으로반환해야한다() {
        // given
        String[] numberArray = {"1", "2", "3"};
        Numbers numbers = new Numbers(numberArray);

        // when
        Number sum = numbers.sum();

        // then
        assertEquals(sum, new Number(6));
    }
}