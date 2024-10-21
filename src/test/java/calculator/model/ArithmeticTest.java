package calculator.model;

import calculator.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("연산부분 테스트")
class ArithmeticTest {

    private static Stream<Arguments> splitTestData() {
        return Stream.of(
                Arguments.of(
                        new InputData("1,2,3,4"),
                        new DefaultDelimiter(),
                        List.of(1,2,3,4),
                        "기본 구분자 단독 사용"),
                Arguments.of(
                        new InputData("10,20:30,40"),
                        new DefaultDelimiter(),
                        List.of(10,20,30,40),
                        "기본 구분자 혼합 사용"),
                Arguments.of(
                        new InputData("//;\\n7;8;9;4"),
                        new CustomDelimiter(";"),
                        List.of(7,8,9,4),
                        "커스텀 구분자 단독 사용"),
                Arguments.of(
                        new InputData("//.;\\n998.41;3.487"),
                        new CustomDelimiter(".;"),
                        List.of(998,41,3,487),
                        "커스텀 구분자 다수 사용"),
                Arguments.of(
                        new InputData("//^?!\\n18^62?300!483:40,5"),
                        new CustomDelimiter("^?!"),
                        List.of(18,62,300,483,40,5),
                        "구분자 혼합 최대치 사용")

        );
    }

    @ParameterizedTest(name = "{3}")
    @MethodSource("splitTestData")
    @DisplayName("숫자 분리 테스트")
    void splitCalculatorPart(InputData inputData, Delimiter delimiter,
                                                 List<Integer> numbers, String testCase) {
        assertThat(new Arithmetic(delimiter, inputData).getArithmetic()).isEqualTo(numbers);
    }

    private static Stream<Arguments> exceptionTestData() {
        return Stream.of(
                Arguments.of(new InputData("1,2,3!4"),
                        new DefaultDelimiter(),
                        ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError(),
                        "기본 구분자 이외의 특수기호"),
                Arguments.of(new InputData("a1,2:3"),
                        new DefaultDelimiter(),
                        ErrorMessage.INPUT_DATA_WITH_DEFAULT_DELIMITER_FORMAT.getError(),
                        "기본 구분자 이외의 문자"),
                Arguments.of(new InputData("//;\\n1?2;3;4"),
                        new CustomDelimiter(";"),
                        ErrorMessage.ARITHMETIC_WITH_CUSTOM_DELIMITER_FORMAT.getError(),
                        "커스텀,기본 구분자 이외의 특수기호"),
                Arguments.of(new InputData("//a\\n1a2,3a가4"),
                        new CustomDelimiter("a"),
                        ErrorMessage.ARITHMETIC_WITH_CUSTOM_DELIMITER_FORMAT.getError(),
                        "커스텀,기본 구분자 이외의 문자"),
                Arguments.of(new InputData(IntStream.range(1, 32)
                                .mapToObj(i -> "1")
                                .collect(Collectors.joining(","))),
                        new DefaultDelimiter(),
                        ErrorMessage.ARITHMETIC_LENGTH_LIMIT.getError(),
                        "길이 초과"),
                Arguments.of(new InputData("-1,0,1,2,3"),
                        new DefaultDelimiter(),
                        ErrorMessage.ARITHMETIC_RANGE_LIMIT.getError(),
                        "음수 입력"),
                Arguments.of(new InputData("998,999,1000,1001"),
                        new DefaultDelimiter(),
                        ErrorMessage.ARITHMETIC_RANGE_LIMIT.getError(),
                        "1000 초과 입력")
        );
    }

    @ParameterizedTest(name = "{3}")
    @MethodSource("exceptionTestData")
    @DisplayName("예외 발생 테스트")
    void isInvalidArithmetic(InputData inputData, Delimiter delimiter,
                                                 String error, String testCase) {
        assertThatThrownBy(() -> new Arithmetic(delimiter, inputData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(error);
    }

    private static Stream<Arguments> normalTestData() {
        return Stream.of(
                Arguments.of(
                        new InputData("1,2,3,4,"),new DefaultDelimiter(), "기본 구분자가 마지막"),
                Arguments.of(
                        new InputData("1:2:3"), new DefaultDelimiter(),"숫자가 마지막"),
                Arguments.of(
                        new InputData(":1:2:3"), new DefaultDelimiter(),"기본 구분자가 시작"),
                Arguments.of(
                        new InputData("1:2,3"), new DefaultDelimiter(),"기본 구분자 혼합 사용"),
                Arguments.of(
                        new InputData("//;\\n1;2;3;4"), new CustomDelimiter(";"),"커스텀 구분자 1개 사용"),
                Arguments.of(
                        new InputData("//a\\n1a2,3a4"), new CustomDelimiter("a"),"구분자 혼합 사용"),
                Arguments.of(
                        new InputData("//가*\\n1*2가3"), new CustomDelimiter("가*"),"커스텀 구분자 여러개 사용"),
                Arguments.of(new InputData(""), new DefaultDelimiter(), "숫자 0개"),
                Arguments.of(new InputData("1"), new DefaultDelimiter(), "숫자 1개"),
                Arguments.of(new InputData(IntStream.range(1, 30)
                                .mapToObj(i -> "1")
                                .collect(Collectors.joining(","))),
                        new DefaultDelimiter(),
                        "숫자 30개"),
                Arguments.of(new InputData("0,1,2,3"), new DefaultDelimiter(), "최솟값 0"),
                Arguments.of(new InputData("998,999,1000"), new DefaultDelimiter(), "최댓값 1000")
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("normalTestData")
    @DisplayName("정상 작동 테스트")
    void isValidArithmetic(InputData inputData, Delimiter delimiter, String testCase) {
        assertThatCode(() -> new Arithmetic
                (delimiter, inputData))
                .doesNotThrowAnyException();
    }

}