package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {


    @Test
    void 문자열_유효성_검사_성공() {
        //given
        String[] input = {"//*\n1,2:3*4", "//*\n", "1,2,3:4", "1,2,3:4//*\n"};
        //when

        //then
        for (String str : input) {
            assertDoesNotThrow(() -> Validator.validate(str));
        }

    }

    @Test
    void 문자열의_시작과_끝_검사_실패() {
        //given
        String[] input1 = {",3,4:5", "3,4:5:", "3:4//;\n;6;"};
        String[] input2 = {"3:4//;\n;6;", "3,4:5:"};

        //then
        for (String str : input1) {
            assertThrows(IllegalArgumentException.class, () -> Validator.validate(str),
                    "문자열의 시작은 커스텀 구분자 선언 또는 양수여야 합니다");
        }

        for (String str : input2) {
            assertThrows(IllegalArgumentException.class, () -> Validator.validate(str),
                    "문자열의 끝은 커스텀 구분자 종료 선언 또는 양수여야 합니다.");
        }
    }

    @Test
    void 커스텀_구분자_형식_유효성_검사하기_실패() {
        //given
        String[] input = {"//*\1,2:3*4", "/*\n1,2:3*4", "//*n1,2:3*4", "//*1,2:3*4"};

        //then
        for (String str : input) {
            assertThrows(IllegalArgumentException.class, () -> Validator.validate(str),
                    "커스텀 구분자 형식이 올바르지 않습니다.");
        }

    }

}