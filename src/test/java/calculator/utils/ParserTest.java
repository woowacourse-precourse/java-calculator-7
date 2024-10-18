package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.model.Numbers;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    private Parser parser = new Parser();

    @Test
    @DisplayName("parseInput - 정상 상황(input에 사용되는 구분자가 delimiter에 모두 들어가 있으며, 모든 값이 양수이다)")
    void success() {
        // given
        List<Character> delimiter = new ArrayList<>();
        delimiter.add(',');
        delimiter.add(';');
        String input = "1,2;3;4";
        //when
        Numbers numbers = parser.parseInput(delimiter, input);
        //then
        assertThat(numbers.sumNumbers()).isEqualTo(10);
    }

    @Test
    @DisplayName("parseInput - 예외 상황(input에 사용되는 구분자가 delimiter에 없는 경우)")
    void noDelimiter() {
        // given
        List<Character> delimiter = new ArrayList<>();
        delimiter.add(',');
        delimiter.add(';');
        String input = "1+2;3;4";
        //when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseInput(delimiter, input));
    }

    @Test
    @DisplayName("parseInput - 예외 상황(음수가 있는 경우)")
    void hasMinus() {
        // given
        List<Character> delimiter = new ArrayList<>();
        delimiter.add(',');
        delimiter.add(';');
        String input = "1,-2;3;4";
        //when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parseInput(delimiter, input));
    }

    @Test
    @DisplayName("parseInput - input으로 아무것도 안들어왔을 때 Numbers의 합은 0이여야한다.")
    void noInput() {
        // given
        List<Character> delimiter = new ArrayList<>();
        delimiter.add(',');
        delimiter.add(';');
        String input = "";
        //when
        Numbers numbers = parser.parseInput(delimiter, input);
        //then
        assertThat(numbers.sumNumbers()).isEqualTo(0);
    }

    @Test
    @DisplayName("parseInput - input구분자만 들어왔을 때 Numbers의 합은 0이여야한다.")
    void onlyDelimiter() {
        // given
        List<Character> delimiter = new ArrayList<>();
        delimiter.add(',');
        delimiter.add(';');
        String input = ",;,";
        //when
        Numbers numbers = parser.parseInput(delimiter, input);
        //then
        assertThat(numbers.sumNumbers()).isEqualTo(0);
    }
}