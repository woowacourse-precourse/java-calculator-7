package calculator.domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DelimiterExtractorTest {
    @Test
    void 커스텀_구분자_추출 (){
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        // t, n 두 가지 커스텀 구분자가 있는 경우
        String test1 = "//t\\n3//n\\n1:3:2,4";
        Set<Character> delimiters1 = delimiterExtractor.getDelimiters(test1);
        List<Character> expectList1 = new ArrayList<>(Arrays.asList('t', 'n', ':', ','));
        Set<Character> expect1 = new HashSet<>(expectList1);

        Assertions.assertThat(delimiters1.equals(expect1));

        // 문자가 여러개 들어오는 경우, '\\'은 '\'로 인식
        String test2 = "//tt\\n//\\\\n1:33,3";

        Set<Character> delimiters2 = delimiterExtractor.getDelimiters(test2);
        List<Character> expectList2 = new ArrayList<>(Arrays.asList('\\', ':', ','));
        Set<Character> expect2 = new HashSet<>(expectList2);
        Assertions.assertThat(delimiters2.equals(expect2));

    }

}
