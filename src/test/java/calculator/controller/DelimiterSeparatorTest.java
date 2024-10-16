package calculator.controller;

import org.junit.jupiter.api.Test;

import static calculator.controller.DelimiterSeparator.registerDelimiter;
import static org.junit.jupiter.api.Assertions.*;

public class DelimiterSeparatorTest {

    @Test
    void 숫자_시작_구분자_등록_안함(){
        String userInput = "123";
        int index = registerDelimiter(userInput);
        assertEquals(0,index);
    }

    @Test
    void 문자_시작_구분자_등록_성공(){
        String userInput = "//;\n123";
        int index = registerDelimiter(userInput);
        assertEquals(5,index);
    }
}
