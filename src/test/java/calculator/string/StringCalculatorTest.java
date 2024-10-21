package calculator.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * StringCalculator 클래스 테스트
 */
class StringCalculatorTest {
    private StringCalculator calculator;

    /**
     * 각 테스트 메서드 실행 전 실행되는 설정 메서드
     * StringCalculator 객체 초기화
     */
    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    /**
     * 빈 문자열 입력 시 0 반환하는 테스트
     */
    @Test
    void 빈_문자열_0_반환() {
        assertThat(calculator.add("")).isEqualTo(0);
    }

    /**
     * 숫자 하나만 입력 시 해당 숫자 반환하는지 테스트
     */
    @Test
    void 숫자_하나_해당_숫자_반환() {
        assertThat(calculator.add("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분_두숫자_더하기() {
        assertThat(calculator.add("1,2")).isEqualTo(3);
    }

    @Test
    void 쉼표로_구분_여러숫자_더하기() {
        assertThat(calculator.add("1,2,3")).isEqualTo(6);
        assertThat(calculator.add("1,2,3,4,5")).isEqualTo(15);
    }
}