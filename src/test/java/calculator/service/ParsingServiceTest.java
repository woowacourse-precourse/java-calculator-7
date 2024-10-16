package calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParsingServiceTest {
    private ParsingService parsingService;

    @BeforeEach
    void setUp(){
        parsingService = new ParsingService();
    }

    //======================= normal =======================//
    @Test
    void 기본_구분자로_구분된_숫자_파싱() {
        int[] result = parsingService.parseNumbers("1,2:3");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 커스텀_구분자로_구분된_숫자_파싱() {
        int[] result = parsingService.parseNumbers("//;\\n1;2;3");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void 기본_구분자와_커스텀_구분자_혼합_사용() {
        int[] result = parsingService.parseNumbers("//;\\n1;2,3:4");
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    //======================= Exception =======================//
    @Test
    void 커스텀_구분자_형식_오류시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            parsingService.parseNumbers("//\n1,2,3");
        });
    }

    @Test
    void 음수_입력시_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            parsingService.parseNumbers("1,-2,3");
        });
    }

    @Test
    void 유효하지_않은_숫자_형식_예외_발생() {
        assertThrows(IllegalArgumentException.class, () -> {
            parsingService.parseNumbers("1,2,a");
        });
    }
}