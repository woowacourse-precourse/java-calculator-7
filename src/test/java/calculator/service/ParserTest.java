package calculator.service;

import static org.junit.jupiter.api.Assertions.*;

import calculator.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    AppConfig appConfig = new AppConfig();

    @DisplayName("커스텀 구분자 테스트")
    @Test
    void parseCustomSeparator() {
        Parser parser = appConfig.parser();
        String inputString = "//!\n123,456!789";

        List<Integer> integers = parser.parse(inputString);

        List<Integer> compareList = new ArrayList<>();
        compareList.add(123);
        compareList.add(456);
        compareList.add(789);
        assertEquals(compareList, integers);
    }

    @DisplayName("일반 구분자 테스트")
    @Test
    void parseDefault() {
        Parser parser = appConfig.parser();
        String inputString = "123,456:789";

        List<Integer> integers = parser.parse(inputString);

        List<Integer> compareList = new ArrayList<>();
        compareList.add(123);
        compareList.add(456);
        compareList.add(789);
        assertEquals(compareList, integers);
    }

    @DisplayName("빈 문자열 테스트")
    @Test
    void parseEmpty() {
        Parser parser = appConfig.parser();
        String inputString = "";

        List<Integer> integers = parser.parse(inputString);

        List<Integer> compareList = new ArrayList<>();
        assertEquals(compareList, integers);
    }

    @DisplayName("음수 예외")
    @Test
    void parseMinus() {
        Parser parser = appConfig.parser();
        String inputString = "-123,-456!789";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(inputString));
    }


    @DisplayName("숫자가 아닌 숫자 예외")
    @Test
    void parseNotNumeric() {
        Parser parser = appConfig.parser();
        String inputString = "12%3,4#56!78&9";

        assertThrows(IllegalArgumentException.class, () -> parser.parse(inputString));
    }
}