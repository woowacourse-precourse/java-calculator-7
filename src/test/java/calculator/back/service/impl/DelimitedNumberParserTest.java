package calculator.back.service.impl;

import static org.assertj.core.api.Assertions.*;

import calculator.back.exception.InvalidInputException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimitedNumberParserTest {
    @Test
    @DisplayName("구분자가 있는 문자열과 구분자를 넘겼을 때 Integer 타입의 리스트 반환")
    void 구분자_문자열_반환_테스트1() {
        //given
        String inputWithDelimiters = "123|10c11*5.9;1";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        List<Integer> numbers = List.of(123, 10, 11, 5, 9, 1);
        //when
        List<Integer> invokedMethod = DelimitedNumberParser.parseDelimitedNumber(inputWithDelimiters, delimiters);
        //then
        assertThat(numbers).containsAll(invokedMethod);
    }

    @Test
    @DisplayName("빈 문자열과 구분자를 전달했을 때, InvalidInputException 예외 throw")
    void 구분자_문자열_예외_테스트1() {
        //given
        String inputWithDelimiters = "";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        //when
        //then
        assertThatThrownBy(() -> DelimitedNumberParser.parseDelimitedNumber(inputWithDelimiters, delimiters)).isInstanceOf(
                InvalidInputException.class);
    }

    @Test
    @DisplayName("형식에 맞지 않는 문자열과 구분자를 전달했을 때, InvalidInputException 예외 throw")
    void 구분자_문자열_예외_테스트2() {
        //given
        String inputWithDelimiters = "1,2,3,";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        //when
        //then
        assertThatThrownBy(() -> DelimitedNumberParser.parseDelimitedNumber(inputWithDelimiters, delimiters)).isInstanceOf(
                InvalidInputException.class);
    }

}