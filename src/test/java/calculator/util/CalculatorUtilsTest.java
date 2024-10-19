package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

class CalculatorUtilsTest {

    List<String> normalInputs = List.of(
            "",
            "2",
            "2,3:328",
            "//#!ji!!\\n",
            "//\\n",
            "//asI#9\\n1a2,3"
    );
    List<Set<Character>> normalCorrects = List.of(
            Set.of(',', ':'),
            Set.of(',', ':'),
            Set.of(',', ':'),
            Set.of(',', ':', '#', '!', 'j', 'i'),
            Set.of(',', ':'),
            Set.of(',', ':', 'a', 's', 'I', '#', '9')
    );
    List<String> abnormalInputs = List.of(
            "//12",
            "//!@12",
            "/!@\\n12",
            "//!\\n1?2"
    );

    @Test
    void getInput_함수_테스트() {
        for (int i = 0; i < normalInputs.size(); i++) {
            String input = normalInputs.get(i);

            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            if (input.isEmpty()) {
                Assertions.assertThatThrownBy(CalculatorUtils::getInput)
                        .isInstanceOf(NoSuchElementException.class);
            } else {
                Assertions.assertThat(CalculatorUtils.getInput()).isEqualTo(input.replace("\\n", "\n"));
            }
        }
    }

    @Test
    void 커스텀_구분자_추출() {
        for (int i = 0; i < normalInputs.size(); i++) {
            String input = normalInputs.get(i).replace("\\n", "\n");

            Set<Character> separators = new HashSet<>(Set.of(',', ':'));

            CalculatorUtils.extractSeparators(separators, input);

            Assertions.assertThat(separators).isEqualTo(normalCorrects.get(i));
        }
    }

    @Test
    void 사용자_입력_형식_검사_정상() {
        for (int i = 0; i < normalInputs.size(); i++) {
            String input = normalInputs.get(i).replace("\\n", "\n");
            Set<Character> separators = normalCorrects.get(i);

            Assertions.assertThatCode(() -> CalculatorUtils.checkInputFormat(input, separators))
                    .doesNotThrowAnyException();
        }
    }

    @Test
    void 사용자_입력_형식_검사_비정상() {
        for (String abnormalInput : abnormalInputs) {
            String input = abnormalInput.replace("\\n", "\n");

            Set<Character> separators = new HashSet<>(Set.of(',', ':'));
            CalculatorUtils.extractSeparators(separators, input);

            Assertions.assertThatThrownBy(() -> CalculatorUtils.checkInputFormat(input, separators))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}