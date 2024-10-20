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
        assertEquals(3, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
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
        assertEquals(3, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("345", result.get(2));
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
        assertEquals(4, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
        assertEquals("4", result.get(3));
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
        assertEquals(4, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
        assertEquals("45", result.get(3));
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
        assertEquals(1, result.size());
        assertEquals("", result.getFirst());
        
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
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("", result.get(2));
        assertEquals("3", result.get(3));
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
        assertEquals("1", result.getFirst());
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
    }
}