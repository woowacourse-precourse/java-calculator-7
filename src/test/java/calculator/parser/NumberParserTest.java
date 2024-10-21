package calculator.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberParserTest {

    NumberParser numberParser;

    @BeforeEach
    public void setup(){
        numberParser = new NumberParser();
    }

    @Test
    @DisplayName("정삭적인 문자열 숫자")
    public void test1(){
        String numbers = "1,2:3";
        String delimiters = ",|:";
        assertThat(List.of(1,2,3)).isEqualTo(numberParser.parseNumbers(numbers, delimiters));
    }

    @Test
    @DisplayName("양수가 아닌 수가 포함된 문자열 숫자")
    public void test2(){
        String numbers = "0,2:3";
        String delimiters = ",|:";
        assertThatThrownBy(() -> numberParser.parseNumbers(numbers, delimiters))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("양수가 아닌 숫자 포함되어 있습니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력된 경우")
    public void test3(){
        String numbers = "a,2,3";
        String delimiters = ",|:";
        assertThatThrownBy(() -> numberParser.parseNumbers(numbers, delimiters))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 숫자 형식입니다.");
    }

    @Test
    @DisplayName("너무 큰 값이 들어간 경우")
    public void test4(){
        String numbers = "100000000000,2,3";
        String delimiters = ",|:";
        assertThatThrownBy(() -> numberParser.parseNumbers(numbers, delimiters))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 숫자 형식입니다.");
    }


}