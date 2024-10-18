package calculator.util;

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
}