package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeparatorTest {
    @Test
    @DisplayName("커스톰 문자열 추출")
    public void extractCustomCharacterTest() {
        //given
        String input = "//m\\n1m2;3";
        boolean expect = true;
        //when
        Separator separator = new Separator();
        //then
        assertEquals(separator.extractCustomCharacter(input), expect);
        System.out.println(separator.getCharacters());
    }
}
