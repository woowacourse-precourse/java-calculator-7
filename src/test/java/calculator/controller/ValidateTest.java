package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

/**
 * 입력값을 검증하는 Validate 클래스의 테스트 클래스.
 */

class ValidateTest {
    /**
     * 정상적인 입력값을 받았을 때 true를 반환하는지 확인한다.
     */
    @Test
    void trueCaseTest() {
        //given
        String sampleString = "1,2:3";
        String samplePattern = "(//.\\n)?\\d+([" + ",:" + "]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(1, result);
    }

    @Test
    void trueCaseTest2() {
        //given
        String sampleString = "1,2:3,4";
        String samplePattern = "(//.\\n)?\\d+([" + ",:" + "]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(1, result);
    }

    @Test
    void trueCaseTest3() {
        //given
        String sampleString = "1,2:3,4a5";
        String samplePattern = "(//.\\n)?\\d+([" + "a,:" + "]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(1, result);
    }

    @Test
    void trueCaseTest4() {
        //given
        String sampleString = "1,2:3,4^5";
        String samplePattern = "(//.\\n)?\\d+([,^:;]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(1, result);
    }

    /**
     * 허용되지 않는 입력값을 받았을 때 false를 반환하는지 확인한다. 공백 역시 false로 처리한다.
     */
    @Test
    void falseCaseTest() {
        //given
        String sampleString = "1,2:3,4a5";
        String samplePattern = "(//.\\n)?\\d+([" + ",:" + "]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(0, result);
    }

    @Test
    void falseCaseTest2() {
        //given
        String sampleString = "1,2:3,4;5";
        String samplePattern = "(//.\\n)?\\d+([" + "^,:" + "]\\d+)*$";

        //when
        int result = Validate.isValidForm(sampleString, Pattern.compile(samplePattern));
        //then
        assertEquals(0, result);
    }
}