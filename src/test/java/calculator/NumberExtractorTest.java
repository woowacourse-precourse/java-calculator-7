package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberExtractorTest {
    @Test
    void 숫자_추출_성공() {
        //given
        String inputStr = "1,2:3";
        String delimiter = ",|:";  // 기본 구분자

        //when
        List<Integer> result = NumberExtractor.extractNums(inputStr, delimiter);

        //then
        assertEquals(List.of(1, 2, 3), result);
    }

    @Test
    void 숫자_추출_음수_예외() {
        //given
        String inputStr = "1,-2,3";
        String delimiter = ",|:";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberExtractor.extractNums(inputStr, delimiter);
        });

        //then
        assertEquals("음수는 허용되지 않습니다.", exception.getMessage());
    }

    @Test
    void 숫자_잘못된형태_예외() {
        //given
        String inputStr = "1,abc,3";
        String delimiter = ",|:";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberExtractor.extractNums(inputStr, delimiter);
        });

        //then
        assertEquals("잘못된 숫자 형태입니다.", exception.getMessage());
    }
}