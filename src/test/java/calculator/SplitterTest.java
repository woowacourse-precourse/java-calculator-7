package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class SplitterTest {
    @DisplayName("기본 및 커스텀 구분자로 입력된 문자열을 분리해서 리스트로 반환한다.")
    @ParameterizedTest
    @MethodSource("provideStringsForSplit")
    void 문자열_분리_테스트(String userInput, List<String> expectedOutput) {
        // when
        List<String> values = Splitter.splitByDelimiter(userInput);

        // then
        Assertions.assertThat(values).isEqualTo(expectedOutput);
    }

    static Stream<Arguments> provideStringsForSplit() {
        return Stream.of(
                Arguments.of("1", List.of("1")),                  // 구분자 없는 경우
                Arguments.of("1,2:3", List.of("1", "2", "3")),       // 기본 구분자
                Arguments.of("4:5,6", List.of("4", "5", "6")),        // 기본 구분자
                Arguments.of("//;\\n1;2;3", List.of("1", "2", "3")),  // 커스텀 구분자 ;
                Arguments.of("//-\\n1-2-3", List.of("1", "2", "3")),  // 커스텀 구분자 -
                Arguments.of("//+\\n", List.of("")),              // 커스텀 구분자만 있을 때
                Arguments.of("//+\\n1", List.of("1"))              // 커스텀 구분자와 값이 하나일 때
        );
    }
}