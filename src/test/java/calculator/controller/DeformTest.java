package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class DeformTest {

    @Test
    void slice() {
        //given
        String sampleString = "//;\\n1;2;3";

        //when
        String result = Deform.slice(sampleString, 0, 5);

        //then
        assertEquals("//;\\n", result);
    }

    @Test
    void extractNumbers() {
        //given
        String sampleString = "1;2;3";
        char separator = ';';

        //when
        Deform deform = new Deform();

        List<Integer> result = deform.extractNumbers(sampleString, separator);

        //then
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
    }
}