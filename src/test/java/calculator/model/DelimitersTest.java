package calculator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분자 객체 생성 및 도구 관련 테스트")
class DelimitersTest {

    @Test
    public void 구분자_객체_정상_생성() {
        // given
        Map<String, Set<Character>> inputAndResult = new HashMap<>();
        inputAndResult.put("1,2,3", Set.of(',', ':'));
        inputAndResult.put("1,2:3", Set.of(',', ':'));
        inputAndResult.put("//\\n1,2,3", Set.of(',', ':'));
        inputAndResult.put("//;\\n1,2,3", Set.of(',', ':', ';'));
        inputAndResult.put("//.\\n1,2,3", Set.of(',', ':', '.'));
        inputAndResult.put("//;.\\n1,2,3", Set.of(',', ':', ';', '.'));
        inputAndResult.put("//[\\n1,2,3", Set.of(',', ':', '['));
        inputAndResult.put("//[]\\n1,2,3", Set.of(',', ':', '[', ']'));

        inputAndResult.forEach((rawInput, expected) -> {
            // when
            Set<Character> actual = Delimiters.from(rawInput).getDelimiters();

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        });
    }

    @Test
    public void 구분자_중복시_예외_발생() {
        // given
        List<String> inputs = new ArrayList<>();
        inputs.add("//;.;\\n1,2,3");
        inputs.add("//.!.\\n1,2,3");
        inputs.add("//;  .\\n1,2,3");
        inputs.add("////\\n1,2,3");
        inputs.add("//[[]\\n1,2,3");

        // when, then
        inputs.forEach((input) -> {
            Assertions.assertThatThrownBy(() -> {
                System.out.println("input = " + input);
                Delimiters.from(input);
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}