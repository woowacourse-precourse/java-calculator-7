package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TokenizerTest {
    @Test
    void 기본_구분자_테스트() {
        // given
        String s = "1,2:3";
        Tokenizer t = new Tokenizer(s);

        // when
        int[] result = t.toArray();

        // then
        assertArrayEquals(result, new int[]{1, 2, 3});
    }

    @Test
    void 커스텀_구분자_테스트() {
        // given
        String s = "//;\\n1;2:3";
        Tokenizer t = new Tokenizer(s);

        // when
        int[] result = t.toArray();

        // then
        assertArrayEquals(result, new int[]{1, 2, 3});
    }
}
