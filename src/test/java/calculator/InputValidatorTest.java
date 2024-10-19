package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {



    @DisplayName("빈 문자열 입력 0을 반환")
    @Test
    void testEmptyString() {
        // given
        String input = "";

        // when, then: 정상 동작 => 예외 미동작
        String result = InputValidator.validate(input);  // validate 메서드에서 0을 반환하도록 처리

        assertDoesNotThrow(() -> InputValidator.validate(input));
        // then: 빈 문자열 입력 시 0이 반환되는지 확인
        assertEquals("0", result);

    }

    @DisplayName("커스텀 구분자 지정 시 정상 처리") //todo: 이후 커스텀 처리 프로세스 추가할 예정
    @Test
    void testStartsWithDelimiter() {
        // given
        String input = "//";

        // when, then: 정상 동작 => 예외 미동작
        assertDoesNotThrow(() -> InputValidator.validate(input));
    }

    @DisplayName("커스텀 구분자로 시작할 경우 구분자 추출 로직이 호출된다")
    @Test
    void testCustomDelimiterIsCalled() {
        // given: 커스텀 구분자로 시작하는 문자열
        String input = "//;\n1;2;3";

        // when: 커스텀 구분자 검증을 진행
        InputValidator.validate(input);

        // then: CustomDelimiter.getCostumDelimiter가 호출되었음을 확인 (간단한 확인 출력 추가)
        // 추후 Mocking이나 다른 방법으로 이 부분은 확장 가능
        assertTrue(CustomDelimiter.wasCalled());
    }

    @DisplayName("커스텀 구분자 지정 구문 없이 숫자가 아닌 문자가 등장함")
    @Test
    void testInvalidNonCustomDelimiter() {
        // given: 첫 시작이 문자이지만 커스텀 구분자가 아닌 경우
        String input1 = "abc,1,2,3";
        // when, then: 커스텀 구분자로 시작하지 않으면 예외 발생
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input1));
        String input2 = "-abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input2));
        String input3 = ".abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input3));
        String input4 = ":abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input4));
        String input5 = "\\abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input5));
        String input6 = "/abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input6));
        String input7 = " abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input7));
        String input8 = "@abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input8));
        String input9 = "#abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input9));
        String input10 = "!abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input10));
        String input11 = "$abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input11));
        String input12 = "&abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input12));
        String input13 = "(abc,1,2,3";
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input13));
    }

    @DisplayName("양수가 아닌 숫자로 시작시 예외 발생")
    @Test
    void testisNotNegativeNumber() {
        String input = "-1,2,3";
        // when, then: 음수는 예외 발생
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));

    }


    //todo @DisplayName("정상 입력(양수로 시작) 시 파서 호출")

}


