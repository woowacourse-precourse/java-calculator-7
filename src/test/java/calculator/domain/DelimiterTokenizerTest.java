package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DelimiterTokenizerTest {


    @Test
    void 구분자_기준_토큰_분리(){
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();

        // 구분자 및 번호 문자열
        List<Character> delimiterList = new ArrayList<>(Arrays.asList('\\', 'u', ':', ','));
        Set<Character> delimiters = new HashSet<>(delimiterList);
        String numberString = "3\\32u32u111:3444,65"; // 3 32 32 111 3444 65
        DelimiterResult delimiterResult = new DelimiterResult(numberString, delimiters);

        List<Integer> expected = Arrays.asList(3, 32, 32, 111, 3444, 65);

        Assertions.assertThat(delimiterTokenizer.getNumbers(delimiterResult)).isEqualTo(expected);
    }

    @Test
    void 구분자_기준_토큰_분리_예외반환(){
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();

        // 구분자 및 번호 문자열
        List<Character> delimiterList = new ArrayList<>(Arrays.asList('\\', 'u', ':', ','));
        Set<Character> delimiters = new HashSet<>(delimiterList);

        String numberString = "3\\32u32u111:3444,65a"; // 문자열 맨 끝이 구분자

        DelimiterResult delimiterResult = new DelimiterResult(numberString, delimiters);

        Assertions.assertThatThrownBy(() -> delimiterTokenizer.getNumbers(delimiterResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 올바르지 않습니다.");
    }

    @Test
    void 구분자_기준_토큰_분리_구분자가_없는경우(){
        DelimiterTokenizer delimiterTokenizer = new DelimiterTokenizer();

        // 구분자 및 번호 문자열
        List<Character> delimiterList = new ArrayList<>(Arrays.asList('\\', 'u', ':', ','));
        Set<Character> delimiters = new HashSet<>(delimiterList);
        String numberString = "3\\32u32u111a3444a65"; // a라는 구분자는 존재하지 X
        DelimiterResult delimiterResult = new DelimiterResult(numberString, delimiters);

        Assertions.assertThatThrownBy(() -> delimiterTokenizer.getNumbers(delimiterResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력이 올바르지 않습니다.");
    }

}
