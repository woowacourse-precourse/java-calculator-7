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

    @DisplayName("구분자 이외의 글자 입력이 들어오면, 에러 발생")
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

    @DisplayName("입력 문자열의 시작이 잘못되면, 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "a1,2,3",       // 첫 글자가 문자
            "#1,2,3",       // 첫 글자가 특수 문자
            "@//;\n1;2;3",  // 커스텀 구분자가 아닌 특수 문자로 시작
            " ,2,3",        // 공백으로 시작
            ";1,2,3"        // 잘못된 특수 문자로 시작
    })
    void add_invalidStartingCharacter_throwsException(String input) {
        // 문자열이 숫자나 "//"로 시작하지 않으면 IllegalArgumentException이 발생하는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        // 예외 메시지가 예상된 것과 일치하는지 확인
        assertEquals("잘못된 형식입니다. 숫자 또는 '//'로 시작해야 합니다.", exception.getMessage());
    }

    @DisplayName("커스텀 구분자 정의 시 '\\n'이 누락되면, IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "//;1;2;3",   // '\n'이 없고 바로 숫자가 나옴
            "//|1|2|3",   // '\n'이 없고 바로 숫자가 나옴
            "//.123",     // '\n'이 없이 바로 숫자가 나옴
            "//#1#2"      // '\n'이 없고 바로 숫자가 나옴
    })
    void add_missingNewlineAfterCustomDelimiter_throwsException(String input) {
        // 문자열의 앞부분이 "//"인데 그 뒤에 '\n'이 없으면 IllegalArgumentException이 발생하는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        // 예외 메시지가 예상된 것과 일치하는지 확인
        assertEquals("잘못된 형식입니다. 커스텀 구분자 뒤에 '\\n'이 있어야 합니다.", exception.getMessage());
    }

    @DisplayName("숫자가 커스텀 구분자로 사용되면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "//1\n1,2,3",  // 숫자 '1'이 커스텀 구분자로 사용됨
            "//2\n2,3,4",  // 숫자 '2'가 커스텀 구분자로 사용됨
            "//3\n3:4:5",  // 숫자 '3'이 커스텀 구분자로 사용됨
    })
    void add_withNumberAsCustomDelimiter_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        // 예외 메시지가 예상된 것과 일치하는지 확인
        assertEquals("숫자는 커스텀 구분자로 사용할 수 없습니다", exception.getMessage());
    }

    @DisplayName("파이프(`|`)가 구분자 외에 다른 위치에서 사용되면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {
            "//|\n1,2,3",  // | 는 커스텀 구분자가 될 수 없음
            "//||\n2,3,4",  // | 는 커스텀 구분자가 될 수 없음
            "//|||\n3:4:5",  // | 는 커스텀 구분자가 될 수 없음
    })
    void add_withNumberOrPipeMisusedAsCustomDelimiter_throwsException(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CalculatorService.add(input);
        });

        // 예외 메시지가 예상된 것과 일치하는지 확인
        assertEquals("커스텀 구분자 등록의 형식이 잘못되었습니다. 파이프(`|`)는 커스텀 구분자를 구분하는 용도로만 사용할 수 있습니다", exception.getMessage());
    }

    @DisplayName("커스텀 구분자에 대한 성공 로직 테스트")
    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', 6",      // 세미콜론을 커스텀 구분자로 사용
            "'//@\n2@3@4', 9",      // @를 커스텀 구분자로 사용
            "'//#\n1#2#3#4', 10",   // #을 커스텀 구분자로 사용
            "'//.\n5.6.7', 18"      // 점(.)을 커스텀 구분자로 사용
    })
    void add_withCustomDelimiters_returnsSum(String input, int expectedSum) {
        // 입력 문자열을 기반으로 숫자 합계를 계산
        int result = CalculatorService.add(input);

        // 결과가 예상된 값과 같은지 확인
        assertEquals(expectedSum, result);
    }

    @DisplayName("구분자에 대한 성공 로직 테스트")
    @ParameterizedTest
    @CsvSource({
            "'1,2,3', 6",           // 쉼표 구분자
            "'1:2:3', 6",           // 콜론 구분자
            "'1,2:3', 6",           // 쉼표와 콜론 혼합 구분자
    })
    void add_withValidInput_returnsSum(String input, int expectedSum) {
        // 입력 문자열을 기반으로 숫자 합계를 계산
        int result = CalculatorService.add(input);

        // 결과가 예상된 값과 같은지 확인
        assertEquals(expectedSum, result);
    }

    @DisplayName("커스텀 구분자를 사용하더라도 값이 없으면 0을 반환")
    @ParameterizedTest
    @ValueSource(strings = {
            "//;\n",    // 커스텀 구분자만 있고 숫자가 없음
            "//#\n",    // 커스텀 구분자만 있고 숫자가 없음
            "//@\n",    // 커스텀 구분자만 있고 숫자가 없음
    })
    void add_customDelimiterWithNoValues_returnsZero(String input) {
        // 입력 문자열에 값이 없을 때 결과가 0이어야 함
        int result = CalculatorService.add(input);

        // 결과가 0이어야 함
        assertEquals(0, result);
    }

    @DisplayName("커스텀 구분자를 사용하고 숫자가 하나만 들어왔을 때 해당 숫자를 반환")
    @ParameterizedTest
    @CsvSource({
            "'//;\n5', 5",    // 세미콜론 구분자와 숫자 5
            "'//#\n15', 15",  // 샵 구분자와 숫자 15
            "'//@\n20', 20",  // 앳 구분자와 숫자 20
            "'//.\n25', 25"   // 점 구분자와 숫자 25
    })
    void add_customDelimiterWithSingleNumber_returnsNumber(String input, int expected) {
        // 입력 문자열에 숫자가 하나만 있을 때 해당 숫자가 반환되어야 함
        int result = CalculatorService.add(input);

        // 결과가 기대한 숫자와 일치해야 함
        assertEquals(expected, result);
    }

    @DisplayName("커스텀 구분자가 없는 경우 성공 로직 테스트")
    @ParameterizedTest
    @CsvSource({
            "'//\n1,2,3', 6",   // 커스텀 구분자가 없고 쉼표 구분자 사용
            "'//\n1:2:3', 6",   // 커스텀 구분자가 없고 콜론 구분자 사용
            "'//\n4,5:6', 15"   // 커스텀 구분자가 없고 쉼표와 콜론 혼합 사용
    })
    void add_withEmptyCustomDelimiter_returnsSum(String input, int expectedSum) {
        int result = CalculatorService.add(input);
        assertEquals(expectedSum, result);
    }

    @DisplayName("글자 커스텀 구분자를 사용한 성공 로직 테스트")
    @ParameterizedTest
    @CsvSource({
            "'//a\n1a2a3', 6",      // 'a'를 커스텀 구분자로 사용
            "'//ㄱ\n1ㄱ2ㄱ3', 6",    // 'ㄱ'를 커스텀 구분자로 사용
            "'//가\n1가2가3', 6"     // '가'를 커스텀 구분자로 사용
    })
    void add_withCustomLetterDelimiters_returnsSum(String input, int expectedSum) {
        int result = CalculatorService.add(input);
        assertEquals(expectedSum, result);
    }

    @DisplayName("여러 커스텀 구분자를 파이프로 구분하여 처리하는 성공 로직 테스트")
    @ParameterizedTest
    @CsvSource({
            "'//;|:|\\|\n1;2|3:4', 10",     // 세미콜론, 콜론, 파이프를 커스텀 구분자로 사용
            "'//#|*|%\n5#6*7%8', 26",       // 해시, 별표, 퍼센트를 커스텀 구분자로 사용
            "'//@|!|^\n9@10!11^12', 42",    // 앳, 느낌표, 캐럿을 커스텀 구분자로 사용
            "'//가|나|다\n1가2나3다4', 10"   // 한글 구분자 (가, 나, 다) 사용
    })
    void add_withMultipleCustomDelimitersUsingPipe_returnsSum(String input, int expectedSum) {
        int result = CalculatorService.add(input);
        assertEquals(expectedSum, result);
    }


}
