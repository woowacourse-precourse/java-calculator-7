package calculator.util;

import calculator.model.Delimiters;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사용자 입력 검증 테스트")
class InputValidatorTest {

    @Test
    public void 사용자_정상_계산식_입력_테스트() {
        List<String> rawInputs = new ArrayList<>();
        rawInputs.add("1");
        rawInputs.add("1,2,3");
        rawInputs.add("1:2,3");
        rawInputs.add("//!\\n1!4,2:3");
        rawInputs.add("// \\n 1 4 2 3");
        rawInputs.add("//!\"\\n1!4,2:3\"5");
        rawInputs.add("//\\n1,2:3");
        rawInputs.add("//\\n\\n1,2:3\\4n5");

        rawInputs.forEach((rawInput) -> {
            Assertions.assertThatNoException().isThrownBy(() -> {
                String expression = ExtractionUtil.extractExpression(rawInput);
                Delimiters delimiters = Delimiters.from(rawInput);

                System.out.println("rawInput = " + rawInput);
                System.out.println("Expression = " + expression);
                System.out.println("Delimiters = " + delimiters.getDelimiters());
                System.out.println();

                InputValidator.validateExpression(expression, delimiters.getDelimiters());
            });
        });
    }

    @Test
    public void 없는_구분자_계산식에_포함시_예외_발생() {
        List<String> rawInputs = new ArrayList<>();
        rawInputs.add("1!");
        rawInputs.add("1,2#3");
        rawInputs.add("1:2;3");
        rawInputs.add("//!\\n1!4,2@3");
        rawInputs.add("//!\"\\n1!4,2:3'5");
        rawInputs.add("//\\n1 2:3");
        rawInputs.add("//#\\n1,2:3\\45");

        rawInputs.forEach(rawInput -> {
            Assertions.assertThatThrownBy(() -> {
                String expression = ExtractionUtil.extractExpression(rawInput);
                Delimiters delimiters = Delimiters.from(rawInput);

                System.out.println("rawInput = " + rawInput);
                System.out.println("Expression = " + expression);
                System.out.println("Delimiters = " + delimiters.getDelimiters());
                System.out.println();

                InputValidator.validateExpression(expression, delimiters.getDelimiters());
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    public void 유효하지_않은_커스텀_구분자_설정시_예외_발생() {
        List<String> rawInputs = new ArrayList<>();
        rawInputs.add("/\\n1");
        rawInputs.add("//n1,2,3");
        rawInputs.add("//\n1:2,3");
        rawInputs.add("\\n1!4,2:3");
        rawInputs.add("// 1 4 2 3");
        rawInputs.add("//\\1,2:3");

        rawInputs.forEach(rawInput -> {
            Assertions.assertThatThrownBy(() -> {
                String expression = ExtractionUtil.extractExpression(rawInput);
                Delimiters delimiters = Delimiters.from(rawInput);

                System.out.println("rawInput = " + rawInput);
                System.out.println("Expression = " + expression);
                System.out.println("Delimiters = " + delimiters.getDelimiters());
                System.out.println();

                InputValidator.validateExpression(expression, delimiters.getDelimiters());
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }
}