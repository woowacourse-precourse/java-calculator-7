package calculator.function;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomSeparatorFinderTest {
    
    @Test
    public void 구분자_탐색_문자열_6미만(){
        //given
        String input = "1,3,5";
        //when
        CustomSeparatorFinder customSeparatorFinder = new CustomSeparatorFinder(input);
        Optional<Character> result = customSeparatorFinder.execute();

        //then
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void 구분자_탐색_형식_없음(){
        //given
        String input = "1,3,5:7";
        //when
        CustomSeparatorFinder customSeparatorFinder = new CustomSeparatorFinder(input);
        Optional<Character> result = customSeparatorFinder.execute();

        //then
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void 구분자_탐색_성공(){
        //given
        char separator = '^';
        String input = "//" + separator  + "\\n1,3,5:7";
        //when
        CustomSeparatorFinder customSeparatorFinder = new CustomSeparatorFinder(input);
        Optional<Character> result = customSeparatorFinder.execute();

        //then
        assertTrue(result.isPresent());
        assertEquals(separator, result.get());
    }
}