package stringprocess;

import static org.assertj.core.api.Assertions.assertThat;

import constant.Constant;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitterTest {
    private List<String> customSeparator;
    private Splitter splitter;

    @BeforeEach
    void init() {
        customSeparator = new ArrayList<>();
        splitter = new Splitter(Constant.BASIC_SEPARATOR_REGEX, customSeparator);
    }

    @Test
    void 기본구분자로_쪼개기() {
        //given
        String input = "//;\n1;2;3,4:5\n-7\n8,9//|\n100|200\n500:300,100";

        //when
        List<String> strings = splitter.splitByBasicSeparator(input);

        //then
        assertThat(strings.size()).isEqualTo(6);

    }

    @Test
    void 커스텀구분자_쪼개기() {
        //given
        String input = "1--3;4--8;7&&&8&&&9";

        customSeparator.add(";");
        customSeparator.add("--");
        customSeparator.add("&&&");

        //when
        List<String> result = splitter.splitByCustomSeparator(input);

        // 결과 출력
        assertThat(result.size()).isEqualTo(7);
        assertThat(result).containsExactly("1", "3", "4", "8", "7", "8", "9");

    }

}