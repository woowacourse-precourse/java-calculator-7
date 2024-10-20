package stringprocess;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import constant.Constant;
import constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final Validator validator = new Validator(Constant.CUSTOM_SEPARATOR_PREFIX,
            Constant.CUSTOM_SEPARATOR_SUFFIX_TEST);

    @Test
    void 문자열_유효성_검사_성공() {
        //given
        String[] input = {"//*\n1,2:3*4", "//*\n", "1,2,3:4", "1,2,3:4//*\n", "//;\n2;3;4"};

        //then
        for (String str : input) {
            assertDoesNotThrow(() -> validator.validate(str));
        }

    }

    @Test
    void 문자열의_시작과_끝_검사_실패() {
        //given
        String[] input1 = {",3,4:5", "3,4:5:", "3:4//;\\n;6;"};
        String[] input2 = {"3:4//;\\n;6;", "3,4:5:"};

        //then
        for (String str : input1) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    ErrorMessage.START_OF_INPUT_ERROR);
        }

        for (String str : input2) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    ErrorMessage.END_OF_INPUT_ERROR);
        }
    }

    @Test
    void 문자열의_시작과_끝_마지막수가0() {
        //given
        String[] input = {"1,12:3://*\n4*50*6*0", "1,12:3://*\n4*50*6*00", "1,12:3://*\n4*50*6*000"};

        //then
        for (String str : input) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    ErrorMessage.END_OF_INPUT_ERROR);
        }
    }

    @Test
    void 문자열의_시작과_끝_마지막_양수가_0으로끝나는_두자리수이상인_양수인경우() {
        //given
        String input = "1,12:3://*\n4*50*6*300";

        //then
        assertDoesNotThrow(() -> validator.validate(input));
    }

    @Test
    void 커스텀_구분자_형식_유효성_검사하기_실패() {
        //given
        String[] input = {"//*\1,2:3*4", "/*\n1,2:3*4", "//*n1,2:3*4", "//*1,2:3*4"};

        //then
        for (String str : input) {
            assertThrows(IllegalArgumentException.class, () -> validator.validate(str),
                    ErrorMessage.CUSTOM_SEPARATOR_FORMAT_ERROR);
        }

    }

}