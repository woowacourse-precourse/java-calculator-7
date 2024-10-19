package calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @DisplayName("커스텀 구분자로 시작하는 입력은 업데이트된 구분자로 파싱됩니다.")
    @Test
    void statrsWithCustomDelimiter() {
        //given
        String input="1,2:3)4";
        String customDelimiter="\\)";
        int result = 10;
        //when
        Parser.startsWithCustomDelimiter(customDelimiter,input);
        //then
        Assertions.assertEquals(result, Parser.result);
    }

    @DisplayName("숫자로 시작하는 입력은 기본 구분자로 파싱됩니다.")
    @Test
    void startsWithPositiveNumber() {
        ///given
        String input="1,2:3";
        int result= 6;
        //when
        Parser.startsWithPositiveNumber(input);
        //then
        Assertions.assertEquals(result, Parser.result);
    }
}