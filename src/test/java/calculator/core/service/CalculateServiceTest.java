package calculator.core.service;

import calculator.core.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    void before() {
        calculateService = new CalculateService();
    }

    @Test
    void TDD_빈_문자열_일때_0을_반환() {
    	//given
        String input = "";

    	//when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    void TDD_기본_구분자_쉼표_문자열_계산() {
        //given
        String input = "1,2,3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 기본_구분자_혼합_문자열_계산() {
        //given
        String input = "1:2,3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_혼합_문자열_계산() {
        //given
        String input = "//|\\n4|2|3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(9);
    }

    @Test
    void 기본_커스텀_구분자_혼합_문자열_계산() {
        //given
        String input = "//|\\n5:6|7,8";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(26);
    }

    @Test
    void 기본_잘못된_입력값_양수아닐떄_예외처리() {
        //given
        String input = "1:2,a";

        //when
        assertThatThrownBy(() -> calculateService.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_잘못된_입력값_양수아닐떄_예외처리() {
        //given
        String input = "//|\\n1|2|-3";

        //when
        assertThatThrownBy(() -> calculateService.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_테스트케이스1() {
        //given
        String input = "//;\\n1";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(1);
    }

    @Test
    void 정상_테스트케이스2() {
        //given
        String input = "//;\\n1";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(1);
    }

    @Test
    void 정상_테스트케이스3() {
        //given
        String input = "// \\n1 2 3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 정상_테스트케이스4() {
        //given
        String input = "//\\\\n1\\2\\3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 정상_테스트케이스5() {
        //given
        String input = "// \\n1 2:3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }
}
