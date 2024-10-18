package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CalculatorUtilsTest {

    List<String> normalInputs = List.of(
            "2,3:328",
            "//#!ji!!\\n",
            "//\\n",
            "//asI#9\\n12,3"
    );
    List<Set<Character>> normalCorrects = List.of(
            Set.of(',', ':'),
            Set.of(',', ':', '#', '!', 'j', 'i'),
            Set.of(',', ':'),
            Set.of(',', ':', 'a', 's', 'I', '#', '9')
    );
    List<String> abnormalInputs = List.of(
            "//12",
            "//!@12"
    );

    @Test
    void getInput_함수_테스트() {
        for (int i = 0; i < normalInputs.size(); i++) {
            String input = normalInputs.get(i);

            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            Assertions.assertThat(CalculatorUtils.getInput()).isEqualTo(input.replace("\\n" ,"\n"));
        }
    }

    @Test
    void 커스텀_구분자_추출_정상() {
        for (int i = 0; i < normalInputs.size(); i++) {
            String input = normalInputs.get(i).replace("\\n", "\n");

            Set<Character> separators = new HashSet<>(Set.of(',', ':'));

            CalculatorUtils.extractSeparators(separators, input);

            Assertions.assertThat(separators).isEqualTo(normalCorrects.get(i));
        }
    }

    @Test
    void 컴스텀_구분자_추출_비정상() {
        for (int i = 0; i < abnormalInputs.size(); i++) {
            String input = abnormalInputs.get(i).replace("\\n", "\n");

            Assertions.assertThatThrownBy(() -> CalculatorUtils.extractSeparators(new HashSet<>(Set.of(':', ',')), input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}