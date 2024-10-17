package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SplitServiceTest {

    @DisplayName("기본 구분자 분할 확인")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("basicSplit")
    void basicDelimiterSplit(String input, String expected) {
        SplitService splitService = new SplitService();
        List<String> numbers = splitService.split(input);
        assertEquals(expected, numbers.toString());
    }
    static Stream<Arguments> basicSplit(){
        return Stream.of(
                Arguments.of("3,4,5","[3, 4, 5]"),
                Arguments.of("3:4:5","[3, 4, 5]"),
                Arguments.of("3,4:5","[3, 4, 5]"),
                Arguments.of("3","[3]")
        );
    }
    @DisplayName("커스텀 구분자 분할 확인")
    @ParameterizedTest(name = "{displayName}: {0}")
    @MethodSource("customSplit")
    void CustomDelimiterSplit(String input, String expected) {
        SplitService splitService = new SplitService();
        List<String> numbers = splitService.split(input);
        assertEquals(expected, numbers.toString());
    }
    static Stream<Arguments> customSplit(){
        return Stream.of(
                Arguments.of("//;\\n3;4;5","[3, 4, 5]"),
                Arguments.of("//;\\n3;4,5","[3, 4, 5]"),
                Arguments.of("// \\n3 4 5","[3, 4, 5]"),
                Arguments.of("//\\s\\n3 4 5","[3, 4, 5]"),
                Arguments.of("//and\\n3and4and5","[3, 4, 5]"),
                Arguments.of("//;\\n3","[3]")
        );
    }
}