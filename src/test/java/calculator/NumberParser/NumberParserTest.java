package calculator.NumberParser;

import calculator.model.NumberParser;
import calculator.model.dto.DelimiterInputData;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberParserTest {

    @Test
    void extractNumbers_커스텀_구분자가_없는_경우_통과() {
        //given
        DelimiterInputData delimiterInputData = new DelimiterInputData(null, "1,2,3");
        //when
        NumberParser numberParser = new NumberParser(delimiterInputData);
        //then
        Assertions.assertEquals(numberParser.extractNumbers(), List.of(1L, 2L, 3L));
    }

    @Test
    void extractNumbers_커스텀_구분자가_있는_경우_통과() {
        //given
        DelimiterInputData delimiterInputData = new DelimiterInputData(';', "1;2,3");
        //when
        NumberParser numberParser = new NumberParser(delimiterInputData);
        //then
        Assertions.assertEquals(numberParser.extractNumbers(), List.of(1L, 2L, 3L));
    }

    @Test
    void extractNumbers_빈리스트의_경우() {
        //given
        DelimiterInputData delimiterInputData = new DelimiterInputData(null, "");
        //when
        NumberParser numberParser = new NumberParser(delimiterInputData);
        //then
        Assertions.assertEquals(numberParser.extractNumbers(), List.of());
    }

    @Test
    void extractNumbers_구분자만_있는_경우() {
        //given
        DelimiterInputData delimiterInputData = new DelimiterInputData(null, ",,,,");
        //when
        NumberParser numberParser = new NumberParser(delimiterInputData);
        //then
        Assertions.assertEquals(numberParser.extractNumbers(), List.of());
    }

    @Test
    void extractNumbers_오버플로우_숫자_파싱_경우() {
        //given
        DelimiterInputData delimiterInputData = new DelimiterInputData(null,
                "1;9999999999999999999999999999999999999999999999999,3");
        //when
        NumberParser numberParser = new NumberParser(delimiterInputData);
        //then
        Assertions.assertThrows(IllegalArgumentException.class, numberParser::extractNumbers);
    }


}
