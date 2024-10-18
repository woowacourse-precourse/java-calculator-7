package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorParserTest {
    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 존재여부 파악(존재할 경우)")
    @Test
    void test1() {
        String given = "//;\\n1;2;3";
        boolean expected = true;
        SeparatorParser separatorParser = new SeparatorParser(given);

        boolean result = separatorParser.isCustomSeparatorExist();

        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 존재여부 파악(존재하지 않을 경우)")
    @Test
    void test2() {
        String given = "1:2:3";
        boolean expected = false;
        SeparatorParser separatorParser = new SeparatorParser(given);

        boolean result = separatorParser.isCustomSeparatorExist();

        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 리턴하기")
    @Test
    void test3() {
        String given = "//ㅋ\\n1;2;3";
        String expected = "ㅋ";
        SeparatorParser separatorParser = new SeparatorParser(given);
        separatorParser.isCustomSeparatorExist();

        String result = separatorParser.getCustomSeparator();
        assertEquals(expected, result);
    }

    @DisplayName("시작에 커스텀 구분자(//\n)를 지정할경우 해당 커스텀 구분자를 리턴하기")
    @Test
    void test3_1() {
        String given = "//ㅋㅋㅋ\\n1;2;3";
        String expected = "ㅋㅋㅋ";
        SeparatorParser separatorParser = new SeparatorParser(given);
        separatorParser.isCustomSeparatorExist();

        String result = separatorParser.getCustomSeparator();
        assertEquals(expected, result);
    }

    @DisplayName("커스텀 구분자가 존재할경우 수식에 해당하는 부분 리턴하기")
    @Test
    void test4() {
        String given = "//ㅋㅋㅋ\\n1;2;3";
        String expected = "1;2;3";
        SeparatorParser separatorParser = new SeparatorParser(given);
        separatorParser.isCustomSeparatorExist();

        String result = separatorParser.getMathematicalExpression();
        assertEquals(expected, result);
    }
}
