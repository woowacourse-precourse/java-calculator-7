package calculator.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    @Test
    void 검사기_0으로_시작하는_정수(){
        //given
        List<String> inputString = new ArrayList<>();
        inputString.add("00123");
        String separator = "[,:]";
        //when, then
        Checker checker = new Checker(inputString, separator);
        assertThrows(IllegalStateException.class, checker::execute);

        
    }
    
    @Test
    void 검사기_문자열_구분자_포함(){
        //given
        List<String> inputString = new ArrayList<>();
        inputString.add("1243");
        String separator = "[,:4]";
        //when, then
        Checker checker = new Checker(inputString, separator);
        assertThrows(IllegalStateException.class, checker::execute);
        
    }
    
    @Test
    void 검사기_정수_형태_아닌_문자(){
        //given
        List<String> inputString = new ArrayList<>();
        inputString.add("12^3");
        String separator = "[,:]";
        //when, then
        Checker checker = new Checker(inputString, separator);
        assertThrows(IllegalStateException.class, checker::execute);
    }
    
    @Test
    void 검사기_통과(){
        //given
        List<String> inputString = new ArrayList<>();
        inputString.add("123");
        String separator = "[,:]";
        //when, then
        Checker checker = new Checker(inputString, separator);
        assertDoesNotThrow(checker::execute);
        
    }
    @Test
    void 검사기_빈_문자열(){
        //given
        List<String> inputString = new ArrayList<>();
        inputString.add("");
        String separator = "[,:]";
        //when, then
        Checker checker = new Checker(inputString, separator);
        assertDoesNotThrow(checker::execute);
    }
}