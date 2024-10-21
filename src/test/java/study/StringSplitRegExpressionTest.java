package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringSplitRegExpressionTest {

    @Test
    void 없거나_한개_이상은_공백도_매칭된다() {
        Pattern pattern = Pattern.compile("[\\d*,|;]*");

        assertThat(pattern.matcher("").matches()).isTrue();
        assertThat(pattern.matcher(",|").matches()).isTrue();
        assertThat(pattern.matcher(",1|").matches()).isTrue();
    }

    @Test
    @DisplayName("String.split(): 기본적으로 결과 배열의 끝에 있는 빈 문자열을 제거")
    void 문자열_split() {
        // split 과정: ["", ""] -> 끝 제거 [""] -> 끝 제거 [] -> empty list
        List<String> containsOnlyEmpty = split(",|");
        // split 과정: ["", "1", ""] -> 끝 제거 ["", "1"]
        List<String> containsLastEmpty = split(",1|");
        // split 과정: ["", "", "1"]
        List<String> containsLastNumber = split(",|1");

        assertThat(containsOnlyEmpty).isEmpty();
        assertThat(containsLastEmpty).containsExactly("", "1");
        assertThat(containsLastNumber).containsExactly("", "", "1");
    }

    @Test
    @DisplayName("빈 문자열 split(): 정규 표현식 일치 여부와 상관없이 빈 문자열을 하나의 요소로 취급")
    void 정규식_불일치_빈_문자열() {
        List<String> match = split("");
        List<String> unMatch = Arrays.stream("".split("\\d+"))
                .toList();

        assertThat(match).containsExactly("");
        assertThat(unMatch).containsExactly("");
    }

    private List<String> split(String input) {
        return Arrays.stream(input.split("[,|;]"))
                .toList();
    }

}
