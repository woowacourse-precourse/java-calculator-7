package calculator.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser = new InputParser();

    @Test
    @DisplayName("기본구분자 사용확인 테스트")
    public void checkDefaultDelimiterTest() {
        //given
        String input = "1,2:3";
        String input2 = "1";

        //when
        boolean hasDefaultDelimiter = inputParser.checkDefaultDelimiter(input);
        boolean hasDefaultDelimiter2 = inputParser.checkDefaultDelimiter(input2);

        //then
        assertThat(hasDefaultDelimiter).isTrue();
        assertThat(hasDefaultDelimiter2).isTrue();
    }

    @Test
    @DisplayName("기본구분자 사용확인 예외 테스트")
    public void checkDefaultDelimiterExceptionTest() {
        //given
        String input = "1;2,3";

        //when
        boolean hasDefaultDelimiter = inputParser.checkDefaultDelimiter(input);

        //then
        assertThat(hasDefaultDelimiter).isFalse();
    }
    
}