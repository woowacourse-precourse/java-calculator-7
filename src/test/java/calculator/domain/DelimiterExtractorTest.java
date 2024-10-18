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
        DelimiterResult result1 = delimiterExtractor.getDelimiters(test1);
        Set<Character> delimiters1 = result1.getDelimiters();
        List<Character> expectList1 = new ArrayList<>(Arrays.asList('t', ':', ','));
        Set<Character> expect1 = new HashSet<>(expectList1);
        String expectNumber1 = "3//n\\n1:3:2,4";

        Assertions.assertThat(delimiters1).isEqualTo(expect1);
        Assertions.assertThat(result1.getNumberString()).isEqualTo(expectNumber1);

        // '\\'은 '\'로 인식
        String test2 = "//t\\n//\\\\n1:33,3";

        DelimiterResult result2 = delimiterExtractor.getDelimiters(test2);
        Set<Character> delimiters2 = result2.getDelimiters();
        String numberString2 = result2.getNumberString();
        List<Character> expectList2 = new ArrayList<>(Arrays.asList('t', '\\', ':', ','));
        Set<Character> expect2 = new HashSet<>(expectList2);
        String expectNumber2 = "1:33,3";

        Assertions.assertThat(delimiters2).isEqualTo(expect2);
        Assertions.assertThat(numberString2).isEqualTo(expectNumber2);
    }

}
