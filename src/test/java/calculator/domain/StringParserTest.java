package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StringParserTest {

    @Nested
    class 예외_처리_테스트를_진행한다 {

        @Test
        void 빈_문자열_입력시_예외를_발생시킨다() {
            //given
            String input = "";
            String expected = "빈 값을 입력하셨습니다.";

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    () -> new StringParser(input));

            //then
            assertEquals(expected, actual.getMessage());
        }

        @Test
        void 잘못된_커스텀_구분자_입력시_예외를_발생시킨다() {
            //given
            String input = "//;1;2;3";
            String expected = "올바른 형식으로 입력하세요.";

            //when
            IllegalArgumentException actual = assertThrows(IllegalArgumentException.class,
                    () -> new StringParser(input));

            //then
            assertEquals(expected, actual.getMessage());
        }
    }
}
