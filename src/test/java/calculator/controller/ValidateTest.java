package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
        ArrayList<String> trueSamples = new ArrayList<>();
        trueSamples.add("1,2:3");
        trueSamples.add("1,2");
        trueSamples.add("1,2,3");
        trueSamples.add("//a\\n1a2a3");
        trueSamples.add("//.\\n1231.156454.15867651");

        //when
        //then
        trueSamples.forEach(sample -> {
            assertEquals(true, Validate.isValidForm(sample));
        });
    }

    /**
     * 허용되지 않는 입력값을 받았을 때 false를 반환하는지 확인한다. 공백 역시 false로 처리한다.
     */
    @Test
    void falseCaseTest() {
        //given
        ArrayList<String> falseSamples = new ArrayList<>();
        falseSamples.add("1,2:3,");
        falseSamples.add("1,2,");
        falseSamples.add("askv;jasdfnlvalksdkjaxc;nlkasd");
        falseSamples.add("0,");
        falseSamples.add("");

        //when
        //then
        falseSamples.forEach(sample -> {
            assertEquals(false, Validate.isValidForm(sample));
        });
    }
}