package calculator.util;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    @DisplayName("구분자 추출 - 커스텀 구분자가 없는 경우")
    void extractBasicDelimiter() {
        //given
        String input = "1:2;3";

        //when
        String result = inputParser.extractDelimiter(input);

        //then
        Assertions.assertEquals("[,:]", result);
    }

    @Test
    @DisplayName("구분자 추출 - 커스텀 구분자가 있는 경우")
    void extractDelimiterWithCustomDelimiter() {
        //given
        String input = "//;\\n1";

        //when
        String result = inputParser.extractDelimiter(input);

        //then
        Assertions.assertEquals("[,:;]", result);
    }

    @Test
    @DisplayName("구분자로 문자열 분리 - 분리 성공한 경우")
    void parseStringToList() {
        //given
        String input = "//.\\n1,2:3;4";
        String delimiter = "[,:;]";
        List<String> expected = Arrays.asList("1", "2", "3", "4");

        //when
        List<String> result = inputParser.parseStringToList(input, delimiter);

        //then
        Assertions.assertEquals(expected, result);
    }
}