package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

class UserInputTest {

    String customDelimiter;
    String delimiterSection;
    String numberString;
    String regex = "^(\\/\\/)([^a-zA-Z0-9.: ]{1})";

    @ParameterizedTest
    @MethodSource("validInputs")
    @DisplayName("정상입력")
    void validSeparateDelimAndNumbers(String input,String exceptedDelimiter,String expectedNumberString) {
        separateDelimAndNumbers(input);
        Assertions.assertThat(exceptedDelimiter).isEqualTo(customDelimiter);
        Assertions.assertThat(expectedNumberString).isEqualTo(numberString);
    }
    @ParameterizedTest
    @MethodSource("inValidInputs")
    @DisplayName("잘못된 입력")
    void InvalidSeparateDelimAndNumbers(String input,String expectedDelimiter,String expectedNumberString) {
        Assertions.assertThatThrownBy(() -> separateDelimAndNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public void separateDelimAndNumbers(String input) {
        String[] split = input.split("\n");
        if(split.length==1) { // 커스텀 구분자가 존재하지 않는 경우
            numberString = split[0];
        }else if(split.length==2) {
            delimiterSection = split[0];
            numberString = split[1];
            extractDelimiter(delimiterSection);
        }else {
            throw new IllegalArgumentException("커스텀 구분자 형식이 일치하지 않습니다.");
        }
    }

    private void extractDelimiter(String delimiterSection) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(delimiterSection);
        if(matcher.matches()) {
            customDelimiter = matcher.group(2);
        }else {
            throw new IllegalArgumentException();
        }
    }
    static Stream<Object[]> validInputs() {
        return Stream.of(new Object[]{"//;\n1;2;3", ";", "1;2;3"},
                new Object[]{"1.2:3",null,"1.2:3"},
                new Object[]{"//#\n4.5#6:7", "#", "4.5#6:7"},
                new Object[]{"//@\n7@8:9.10", "@", "7@8:9.10"},
                new Object[]{"//^\n7^8.9:10","^","7^8.9:10"});
    }
    static Stream<Object[]> inValidInputs() {
        return Stream.of(new Object[]{"//;\\n1;2;3",";","1;2;3"}, // 커스텀 형식이 일치하지 않는경우
                new Object[]{"//;1;2;3",";","1;2;3"},
                new Object[]{"//;\n\n1;2;3",";","1;2;3"},
                new Object[]{"//.\n1;2;3",".","1;2;3"}, //기존 커스텀 구분자
                new Object[]{"//:\n1;2;3",":","1;2;3"});
    }
}