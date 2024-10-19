package calculator.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserUtilTest {


    @Test
    @DisplayName("커스텀 구분자를 판별 후, 구분자를 기준으로 문자열을 분리한다.")
    void testSeperator() {
        // given
        String input1 = "1,2,3";
        String input2 = "//;\\n1;2;3";
        String input3 = "1";
        String input4 = "/,1,2,3";
        String input5 = "//;\\n;2;";
        String input6 = "//;\\n1;2;";
        String input7 = "//.\\n1.2.3";
        String input8 = "//@@\\n1@@2@@3";
        String input9 = "1:2::3";

        // when
        String[] result1 = InputParserUtil.seperator(input1);
        String[] result2 = InputParserUtil.seperator(input2);
        String[] result3 = InputParserUtil.seperator(input3);
        String[] result4 = InputParserUtil.seperator(input4);
        String[] result5 = InputParserUtil.seperator(input5);
        String[] result6 = InputParserUtil.seperator(input6);
        String[] result7 = InputParserUtil.seperator(input7);
        String[] result8 = InputParserUtil.seperator(input8);
        String[] result9 = InputParserUtil.seperator(input9);

        // then
        assertThat(result1).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(result2).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(result3).isEqualTo(new String[]{"1"});
        assertThat(result4).isEqualTo(new String[]{"/", "1", "2", "3"});
        assertThat(result5).isEqualTo(new String[]{"", "2", ""});
        assertThat(result6).isEqualTo(new String[]{"1", "2", ""});
        assertThat(result7).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(result8).isEqualTo(new String[]{"//@@\\n1@@2@@3"});
        assertThat(result9).isEqualTo(new String[]{"1", "2", "", "3"});
    }

    @Test
    @DisplayName("양수를 판별해 정수형으로 형변환 시켜준다.")
    void numberStrListToIntList() {
        String[] input1 = new String[]{"1", "2", "3"};
        String[] input2 = new String[]{"", "2", "3"};
        String[] input3 = new String[]{"-1", "2", "3"};

        int[] result1 = InputParserUtil.numberStrListToIntList(input1);

        assertThat(result1).isEqualTo(new int[]{1, 2, 3});

        assertThatThrownBy(() -> InputParserUtil.numberStrListToIntList(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");

        assertThatThrownBy(() -> InputParserUtil.numberStrListToIntList(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다.");
    }
}
