package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class MetaCharacterRegExTest {

    @Test
    void 자바의_메타_문자_처리() {
        String s = "//;\\\\n1;\\2;\\3";
        Pattern pattern = Pattern.compile("//(.)+\\\\n(.)*");
        assertThat(pattern.matcher(s).matches()).isTrue();

        List<String> list = Arrays.stream(s.split("\\\\n")).toList();
        assertThat(list).containsExactly("//;\\", "1;\\2;\\3");

        String delimiter = Pattern.quote(list.getFirst().replaceAll("//", ""));
        assertThat(delimiter).isEqualTo("\\Q;\\\\E");

        assertThat(list.getLast().split(delimiter)).containsExactly("1", "2", "3");
    }

    @Test
    void 메타문자_정규_표현식() {
        Pattern backslashNPattern = Pattern.compile("\\\\n");
        Pattern lineFeedPattern = Pattern.compile("\n");

        String backslashN = "\\n";
        String lineFeed = "\n";

        assertThat(backslashNPattern.matcher(backslashN).matches()).isTrue();
        assertThat(lineFeedPattern.matcher(backslashN).matches()).isFalse();

        assertThat(backslashNPattern.matcher(lineFeed).matches()).isFalse();
        assertThat(lineFeedPattern.matcher(lineFeed).matches()).isTrue();
    }

}
