package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SplitterTest {

    @Test
    void 기본구분자로_쪼개기() {
        //given
        String input = "//;\n1;2;3,4:5\n-7\n8,9//|\n100|200\n500:300,100";
        Splitter splitter = new Splitter();

        //when
        List<String> strings = splitter.splitByBasicSeparator(input);

        //then
        assertThat(strings.size()).isEqualTo(6);

    }

    @Test
    void 커스텀구분자_쪼개기() {
        //given
        String input = "1--3;4--8;7&&&8&&&9";
        Splitter splitter = new Splitter();
        List<String> customSeparator = new ArrayList<>();
        customSeparator.add(";");
        customSeparator.add("--");
        customSeparator.add("&&&");

        //when
        List<String> result = splitter.splitByCustomSeparator(input, customSeparator);

        // 결과 출력
        assertThat(result).containsExactly("1", "3", "4", "8", "7", "8", "9");

    }

}