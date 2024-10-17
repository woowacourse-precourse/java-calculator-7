package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3 . false",
            ",1:2 . false",
            "//a\\n1a2a3 . true",
            "/=\\n1=2=3 . false",
            "// \\n1 2 3 . true",
            " . false",
            "//a\\3a2a1 . false"},
            delimiter = '.'
    )
    @DisplayName("커스텀 구분자 존재 유무 판단 테스트")
    void hasCustomDelimiter(String delimiter, boolean expected){
        boolean result = Parser.hasCustomDelimiter(delimiter);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "//a\\n1a2a3a1 . a",
            "//||\\n1||2||3||1 . ||",
            "// \\n1 2 4 . ' '"},
            delimiter = '.'
    )
    @DisplayName("커스텀 구분자 추출 테스트")
    void extractCustomDelimiter(String string, String expected){
        String result = Parser.extractCustomDelimiter(string);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource(value = "inputAndDelimiterAndNumbers")
    @DisplayName("구분자 기준으로 숫자 리스트 추출 테스트")
    void parseNumbersFromInput(String input, List<String> delimiter, List<Integer> expected){
        // when
        List<Integer> result = Parser.parseNumbersFromInput(input, delimiter);
        // then
        assertThat(result.size()).isEqualTo(expected.size());
        for(int i=0; i<expected.size(); i++)
            assertThat(result.get(i)).isEqualTo(expected.get(i));
    }

    public static Stream<Arguments> inputAndDelimiterAndNumbers(){
        return Stream.of(
                Arguments.arguments("//a\\n1a2a3a1", List.of("a"), List.of(1,2,3,1)),
                Arguments.arguments("//||\\n1||2||3||1", List.of("||"), List.of(1,2,3,1)),
                Arguments.arguments("// \\n1 2 4 ", List.of(" "), List.of(1,2,4)),
                Arguments.arguments("1:2,5", List.of(":",","), List.of(1,2,5)),
                Arguments.arguments("1,2,4,6,8", List.of(":",","), List.of(1,2,4,6,8)),
                Arguments.arguments(":,:", List.of(":",","), List.of()),
                Arguments.arguments("", List.of(":",","), List.of()),
                Arguments.arguments(",", List.of(":",","), List.of()),
                Arguments.arguments("//-\\n", List.of("-"), List.of()),
                Arguments.arguments("//-\\n3", List.of("-"), List.of(3))
        );
    }
}