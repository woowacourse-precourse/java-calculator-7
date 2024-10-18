package calculator.util.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("InputParser.getDelimiter() 성공 테스트")
    void testValidateInputSuccessCase() {
        //given
        String defaultTest1 = "1,2,3";
        String defaultTest2 = "1:2:3";
        String defaultTest3 = "1,2:3";
        String defaultTest4 = "1";

        String customTest4 = "//;\n1;2;3";
        String customTest5 = "//-\n4-5-6";

        String[] defaultTestSets = {defaultTest1, defaultTest2, defaultTest3,defaultTest4};
        //when
        for (String test : defaultTestSets) {
            assertEquals(InputParser.getDelimiterAndRawData(test).delimiter(),",|:");
        }
    }
    @Test
    @DisplayName("InputParser.validateInput() 실패 테스트")
    void testValidateInputFailCase() {
        //given
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("1, 2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData(",1,2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("1,2'3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("1,b,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("1,,3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("//-\\n1,2-3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("//-\\n1-2-"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputParser.getDelimiterAndRawData("//-\\n1-2--3"))
                .isInstanceOf(IllegalArgumentException.class);
        //when

        //then
    }

    @Test
    void extractNumberTest() {
        String test1 = "1,2:3";
        System.out.println(InputParser.extractNumbers(test1));

        String test2 = "//}\\n4}5}6";
        System.out.println(InputParser.extractNumbers(test2));

        String test3 = "//q\\n6q7q8";
        System.out.println(InputParser.extractNumbers(test3));
    }
}