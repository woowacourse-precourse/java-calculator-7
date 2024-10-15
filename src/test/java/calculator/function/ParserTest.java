package calculator.function;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void 파싱_성공(){
        //given
        String inputString = "1,2:3";
        String separator = ",:";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 3);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "3");
    }

    @Test
    void 파싱_2자릿수_성공(){
        //given
        String inputString = "1,2:345";
        String separator = ",:";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 4);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "345");
    }

    @Test
    void 파싱_커스텀구분자_성공(){
        //given
        String inputString = "1,2:3^4";
        String separator = ",:^";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 4);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "3");
        assertEquals(result.get(3), "4");
    }

    @Test
    void 파싱_정수_성공(){
        //given
        String inputString = "1,2:3045";
        String separator = ",:0";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 4);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "3");
        assertEquals(result.get(3), "45");
    }
    
    @Test
    void 파싱_빈_문자열(){
        //given
        String inputString = "";
        String separator = ",:";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 1);
        assertEquals(result.getFirst(), "");
        
    }
    
    @Test
    void 파싱_연속_구분자(){
        //given
        String inputString = "1,2::3";
        String separator = ",:";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 4);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "");
        assertEquals(result.get(3), "3");
    }
    
    @Test
    void 파싱_구분자로_끝남(){
        //given
        String inputString = "1,2:3,";
        String separator = ",:";

        //when
        Parser parser = new Parser(inputString, separator);
        List<String> result = parser.execute();

        //then
        assertEquals(result.size(), 3);
        assertEquals(result.getFirst(), "1");
        assertEquals(result.get(1), "2");
        assertEquals(result.get(2), "3");
    }
}