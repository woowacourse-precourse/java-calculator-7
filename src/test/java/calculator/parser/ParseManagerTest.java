package calculator.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.dto.Data;
import org.junit.jupiter.api.Test;

class ParseManagerTest {

    @Test
    void 올바른_기본_데이터_파싱_테스트() {

        //given
        String inputData = ",1,2:3,";
        ParseManager parseManager = new ParseManager();

        //when
        Data data = parseManager.parseData(inputData);
        String contents = data.getContents();
        String separators = data.getSeparators();

        //then
        assertEquals(contents, "1,2:3,");
        assertEquals(separators, "[,:]");
    }

    @Test
    void 올바른_커스텀_데이터_파싱_테스트() {
        //given
        String inputData = "//;\\n1;2;3;";
        ParseManager parseManager = new ParseManager();

        //when
        Data data = parseManager.parseData(inputData);
        String contents = data.getContents();
        String separators = data.getSeparators();

        //then
        assertEquals(contents, "1;2;3;");
        assertEquals(separators, "[;:,]");
    }

    @Test
    void 올바르지_않은_기본_데이터_파싱_테스트() {
        //given
        String inputData = ",1;2,3,";
        ParseManager parseManager = new ParseManager();

        //when
        assertThrows(IllegalArgumentException.class, () -> {
            parseManager.parseData(inputData);
        });
    }

    @Test
    void 올바르지_않은_커스텀_데이터_파싱_테스트() {
        //given
        String inputData = "//;\\n\\n,1;2,3,";
        ParseManager parseManager = new ParseManager();

        //when
        assertThrows(IllegalArgumentException.class, () -> {
            parseManager.parseData(inputData);
        });
    }

}