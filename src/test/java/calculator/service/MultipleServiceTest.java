package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultipleServiceTest {

    @Test
    @DisplayName("MultipleService 정상 동작 확인")
    void process() {
        // given
        String args = "//#\n1,2#3:4";
        MultipleService multipleService = new MultipleService();
        int expect = 10;

        // when
        int result = multipleService.process(args);

        // then
        assertEquals(expect, result);
    }

}
