package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class AdditionTest {

    @Test
    void 문자열에서_추출한_숫자_덧셈하기() {
        //given
        List<Integer> numbers = List.of(2, 3, 4);
        Addition addition = new Addition(numbers);

        //when
        int result = addition.addNumber();

        //then
        assertEquals(9, result);
    }
}