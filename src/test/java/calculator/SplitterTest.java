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

   

}