package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceTest {
    @Test
    @DisplayName("커스텀 구분자가 있을 때 숫자 추출")
    public void extractNumbersTest1() {
        //given
        Separator separator = new Separator();
        separator.extractCustomCharacter("//m\\n1m2,3:4");
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        //when
        Sentence sentence = new Sentence("1m2,3:4");
        //then
        assertEquals(sentence.extractNumbers(separator.getCharacters()), expect);
    }

    @Test
    @DisplayName("커스텀 구분자가 없을 때 숫자 추출")
    public void extractNumbersTest2() {
        //given
        Separator separator = new Separator();
        separator.extractCustomCharacter("1:2,3:4");
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        //when
        Sentence sentence = new Sentence("1:2,3:4");
        //then
        assertEquals(sentence.extractNumbers(separator.getCharacters()), expect);
    }
}
