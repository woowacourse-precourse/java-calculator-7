package calculator;

import calculator.calculator.Calculator;
import calculator.input.Input;
import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 파서_테스트() {
        // given
        List<String> basicSeparators = List.of(",", ":");
        Parser parser = new Parser(basicSeparators);
        Input input = new Input("//", "\\n");

        //when
        String input1 = "//a\\n1:2:3a54";

        Predicate<Integer> positivePolicy = (num) -> num >= 0;
//        Predicate<Integer> minimumPolicy = (num) -> num > 10;
        List<Predicate<Integer>> policies = List.of(positivePolicy);

        // then
        List<String> inputs = input.read(() -> input1);
        System.out.println(inputs);

        parser.updateInput(inputs.get(0));
        parser.addSeparators();

        parser.updateInput(inputs.get(1));
        List<Integer> result = parser.parse(policies);
        List<Integer> expected = List.of(1, 2, 3, 54);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 리더_테스트() {
        Input input = new Input("//", "\\n");

//        System.out.println("//\n\\n32\n12");
        List<String> inputs = input.read(() -> "//\\n\\n32\\n12");
        System.out.println(inputs.size() + ": " + inputs);
    }

    @Test
    void input_에러_테스트() {
        Input input = new Input("//", "\\n");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> inputs = input.read(() -> "//;\\a32;12");
            System.out.println(inputs);
        });
    }

    @Test
    void calculator_빈_피연산자_테스트() {
        // given
        Calculator calculator = new Calculator((a, b) -> a + b);

        // when
        List<Integer> operands = List.of();

        // then
        Integer result = calculator.calculate(operands, 0);
        assertThat(result).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
