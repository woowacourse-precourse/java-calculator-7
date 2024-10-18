package calculator.separator.domain;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class RegexPatternTest {
    @Test
    void extractNumberTest() {
        String s = "1,2,3";
        String s2 = "//;\\n1;2;3"; List<String> excepted = List.of("1","2","3");
        String s3 = "";

        assertThat(RegexPattern.extractNumberProcess(s)).isEqualTo(excepted);
        assertThat(RegexPattern.extractNumberProcess(s2)).isEqualTo(excepted);
        assertThat(RegexPattern.extractNumberProcess(s3)).isEqualTo(List.of(""));
    }
}
