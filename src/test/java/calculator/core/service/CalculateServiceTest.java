package calculator.core.service;

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
    void 커스텀_구분자_포맷_불일치_양수_예외처리() {
        //given
        String input = "// | \\n1|2|33";

        //when
        assertThatThrownBy(() -> calculateService.calculate(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_구분자_양수_예외처리() {
        //given
        String input = "1:2,a";

        //when
        assertThatThrownBy(() -> calculateService.calculate(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_양수_예외처리() {
        //given
        String input = "//|\\n1|2|-3";

        //when
        assertThatThrownBy(() -> calculateService.calculate(input)).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_공백_문자_허용() {
        //given
        String input = "// \\n1 2 3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    void 기본_Long타입_MAX_VALUE_계산() {
        //given
        String input = "9223372036854775807,9223372036854775807";
        BigInteger expectSum = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE));

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(expectSum);
    }

    @Test
    void 커스텀_Long타입_MAX_VALUE_계산() {
        //given
        String input = "//}\\n9223372036854775807}9223372036854775807";
        BigInteger expectSum = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(Long.MAX_VALUE));

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(expectSum);
    }

    @Test
    void 커스텀_구분자가_기본_구분자_동일_허용() {
        //given
        String input = "//:\\n123:456,789,10";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(1378);
    }

    @Test
    void 커스텀_구분자_역슬래쉬_허용() {
        //given
        String input = "//\\\\n1\\2\\3";

        //when
        BigInteger sum = calculateService.calculate(input);

        //then
        assertThat(sum).isEqualTo(6);
    }
}
