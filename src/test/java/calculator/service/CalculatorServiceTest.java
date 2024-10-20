package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("계산기 로직 테스트")
class CalculatorServiceTest {

    @DisplayName("구분자가 잘못 들어 왔을 시, 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "1;2",  // 세미콜론은 기본 구분자가 아님
            "1|2",  // 파이프는 기본 구분자가 아님
            "1 2",  // 공백은 기본 구분자가 아님
            "1/2"   // 슬래시는 기본 구분자가 아님
    })
    void add_invalidDelimiter_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });
        assertEquals("구분자가 적절하지 않습니다", exception.getMessage());
    }

    @DisplayName("여러 숫자 입력에 대한 구분자가 잘못 들어 왔을 시, 에러 발생")
    @ParameterizedTest
    @CsvSource({
            "'1,2;3,4'",  // 첫 번째 잘못된 구분자 (세미콜론)
            "'1,2,3;4'",  // 두 번째 잘못된 구분자 (세미콜론)
            "'1;2,3,4'",  // 첫 번째 잘못된 구분자 (세미콜론)
            "'1,2:3|4'",  // 네 번째 잘못된 구분자 (파이프)
            "'1:2,3/4'",   // 네 번째 잘못된 구분자 (슬래시)
            "'9:10,11/12'", // 네 번째 잘못된 구분자 (슬래시), 네 개의 숫자
            "'9:10,11/12,13'", // 네 번째 잘못된 구분자 (슬래시), 네 개의 숫자
    })
    void add_validAndInvalidMixedDelimiters_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });
        assertEquals("구분자가 적절하지 않습니다", exception.getMessage());
    }

}
