package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StringCalculatorTest {

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @Test
        void 음수_포함시_예외를_발생시킨다() {
            //given
            List<String> numbers = List.of("1", "-2", "3");
            String expected = "음수는 입력 불가합니다.";
            StringCalculator calculator = new StringCalculator(numbers);

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    calculator::calculateStrings);

            //then
            assertEquals(expected, actual.getMessage());
        }

        @Test
        void 연속되는_기본_구분자의_경우_예외를_발생시킨다() {
            //given
            List<String> numbers = List.of("1", "", "2", "3"); //1,,2,3 입력시 StringParser 에서 다음과 같은 리스트를 반환한다.
            String expected = "올바른 숫자 형식이 아닙니다.";
            StringCalculator calculator = new StringCalculator(numbers);

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    calculator::calculateStrings);

            //then
            assertEquals(expected, actual.getMessage());
        }

        @Test
        void 문자가_포함되는_경우_예외를_발생시킨다() {
            //given
            List<String> numbers = List.of("1", "a", "3");
            String expected = "올바른 숫자 형식이 아닙니다.";
            StringCalculator calculator = new StringCalculator(numbers);

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    calculator::calculateStrings);

            //then
            assertEquals(expected, actual.getMessage());
        }

        @Test
        void 잘못된_형식이_리스트에_담길_경우_예외를_발생시킨다() {
            //given
            List<String> numbers = List.of("1?2?3"); //1?2?3? 입력시 StringParser 에서 다음과 같은 리스트를 반환한다.
            String expected = "올바른 숫자 형식이 아닙니다.";
            StringCalculator calculator = new StringCalculator(numbers);

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    calculator::calculateStrings);

            //then
            assertEquals(expected, actual.getMessage());
        }
    }

    @Test
    void 올바른_숫자의_합을_반환한다() {
        //given
        List<String> numbers = List.of("1", "2", "3");
        int expected = 6;
        StringCalculator calculator = new StringCalculator(numbers);

        //when
        int actual = calculator.calculateStrings();

        //then
        assertEquals(expected, actual);
    }
}
