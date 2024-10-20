package calculator.validation;

import calculator.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 구분자_검증_기능_테스트() {
        // given
        Validation validation = new Validation();
        List<String> formulas = new ArrayList<>(
                Arrays.asList("//^\n1,2^3", "1,2,3", "1,2:3", "1,2&3", "$\n1,2,3", "//$$\n1,2,3", "//$1,2,3"));
        List<String> replacedFormulas = formulas.stream()
                .map(Util::newlineConverter)
                .toList();
        List<Boolean> answers = new ArrayList<>(Arrays.asList(true, true, true, false, false, false, false));

        // when
        List<Boolean> result = replacedFormulas.stream()
                .map(formula -> validation.validateDelimiter(formula))
                .toList();

        // then
        IntStream.rangeClosed(0, result.size() - 1)
                .forEach(index -> Assertions.assertThat(result.get(index)).isEqualTo(answers.get(index)));

    }
}