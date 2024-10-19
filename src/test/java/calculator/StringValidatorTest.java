package calculator;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

    @Test
    void 구분자_유효() {
        String userInput = "//;\\n1;2;3";
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(Delimiter.CUSTOM_DOUBLE_SLASH);
        assertThat(StringValidator.delimiterValidator(userInput)).isEqualTo(delimiters);
    }

    @Test
    void 다른_문자_검사() {
        String userInput = "1:2:#$@%!)(*?$3?3";
        assertThat(StringValidator.stringFiter(userInput)).isTrue();
    }

    @Test
    void 커스텀_구분자() {
        String userInput = "//;\n1;2;3";
        assertThat(StringValidator.findCustomDelimiter(userInput)).isEqualTo(";");

    }

    @Test
    void 구분자_세팅() {
        String userInput = "1,2:3";
        List<Delimiter> delimiters = new ArrayList<>();
        delimiters.add(Delimiter.COLON);
        delimiters.add(Delimiter.COMMA);
        List<String> curDelimiters = new ArrayList<>();
        curDelimiters.add(":");
        curDelimiters.add(",");
        assertThat(StringValidator.setDelimiter(userInput, delimiters)).isEqualTo(curDelimiters);
    }

    @Test
    void 커스텀_구분자_문자열_구하기() {
        String userInput = "//;\n1;2;3";
        System.out.println(
                "StringValidator.getSumString(userInput) = " + StringValidator.getSumCustomString(userInput));
        assertThat(StringValidator.getSumCustomString(userInput)).isEqualTo("1;2;3");
    }

    @Test
    void 덧셈_문자열() {
        String userInput = "1,2:3";
        List<String> curDelimiters = new ArrayList<>();
        curDelimiters.add(":");
        curDelimiters.add(",");
        assertThat(StringValidator.getSumString(userInput, curDelimiters)).isEqualTo("1,2:3");
    }

    @Test
    void 덧셈_숫자리스트() {
        String subString = "1,2:3";
        List<String> curDelimiters = new ArrayList<>();
        curDelimiters.add(":");
        curDelimiters.add(",");
        List<String> subStrings = new ArrayList<>();
        subStrings.add("1");
        subStrings.add("2");
        subStrings.add("3");
        assertThat(SumCalculator.getNumbers(subString, curDelimiters)).isEqualTo(subStrings);
    }

    @Test
    void 음수_체크() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(SumCalculator.vaildateNumber(numbers)).isEqualTo(numbers);
    }

    @Test
    void 덧셈() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(SumCalculator.getSumInteger(numbers)).isEqualTo(6);
    }
}