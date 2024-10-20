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

    @DisplayName("글자 입력이 들어오면, 에러 발생")
    @ParameterizedTest
    @CsvSource({
            "'1a2,3'",    // 영어 'a'가 구분자로 들어온 경우
            "'1,2b3'",    // 영어 'b'가 구분자로 들어온 경우
            "'1가2:3'",   // 한글 '가'가 구분자로 들어온 경우
            "'1,나2,3'",  // 한글 '나'가 구분자로 들어온 경우
            "'1,2c3,4'",  // 영어 'c'가 구분자로 들어온 경우
            "'1,2,3한4'", // 한글 '한'이 구분자로 들어온 경우
            "'1d2:3,4'"   // 영어 'd'가 구분자로 들어온 경우
    })
    void add_invalidCharacterDelimiter_throwsException(String input) {

        // 영어 또는 한글이 구분자로 포함되어 있으면 예외가 발생해야 함
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        assertEquals("글자는 들어올 수 없습니다", exception.getMessage());
    }

    @DisplayName("음수 입력이 들어오면, 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "1,-2,3",   // 음수가 두 번째 위치
            "-1,2,3",   // 음수가 첫 번째 위치
            "1,2,-3",   // 음수가 세 번째 위치
            "-1,-2,3",  // 음수가 첫 번째와 두 번째 위치
            "1,-2:-3"   // 음수가 두 번째와 세 번째 위치, 콜론과 쉼표 혼합
    })
    void add_negativeNumber_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        // 예외 메시지에 음수가 포함되어 있는지 확인
        assertEquals("음수는 허용되지 않습니다", exception.getMessage());
    }

}
