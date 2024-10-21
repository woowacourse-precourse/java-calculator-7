package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SumServiceTest {

    private final SumService sumService = new SumService();

    @Test
    void testCalculateSumWithDefaultDelimiters() {
        assertEquals(6, sumService.calculateSum("1,2:3"));
    }

    @Test
    void testCalculateSumWithCustomDelimiter() {
        assertEquals(6, sumService.calculateSum("//;\\n1;2;3"));
    }

    @Test
    void testCalculateSumWithMixedDelimiters() {
        assertEquals(10, sumService.calculateSum("//;\\n1;2,3:4"));
    }

    @Test
    void testCalculateSumWithMultiDelimiters() {
        assertEquals(10, sumService.calculateSum("//;\\n//a\\n1;2a3:4"));
    }

    @Test
    void testCalculateSumWithEmptyInput() {
        assertEquals(0, sumService.calculateSum(""));
    }

    @Test
    void testCalculateSumWithSingleNumber() {
        assertEquals(5, sumService.calculateSum("5"));
    }


    @Test
    void testCalculateSumWithLeadingAndTrailingSpaces() {
        assertEquals(6, sumService.calculateSum("  1 , 2 , 3  "));
    }

}