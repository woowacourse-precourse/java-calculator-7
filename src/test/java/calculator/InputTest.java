package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.constants.ExceptionCode;
import org.junit.jupiter.api.Test;

public class InputTest {


    @Test
    void inputSplit() {
        // given
        Separators separators = new Separators();

        // when
        final int[] numbers = separatorInput(separators);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    private int[] separatorInput(Separators separators) {
        Input input = new Input("1,2,3");
        String regex = separators.getRegex();
        String[] splitStr = input.getInput().split(regex);

        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            numbers[i] = Integer.parseInt(splitStr[i]);
        }
        return numbers;
    }

    @Test
    public void inputContainEnter() {
        // given
        Input input = new Input("//;\n2,3");

        // when
        boolean isStart = input.getInput().startsWith("//");
        boolean contains = input.getInput().contains("\n");

        // then
        assertThat(isStart).isTrue();
        assertThat(contains).isTrue();
    }

    @Test
    public void separatorInputWithCostume() {
        // given
        Separators separators = new Separators();
        String splitInputWithSeparator = separators.containCustomSeparator("//;\\n1;2;3");
        Input input = new Input(splitInputWithSeparator);

        // when
        String[] splitStr = input.splitBySeparator(separators);

        // then
        for (int i = 0; i < splitStr.length; i++) {
            System.out.println(splitStr[i]);
        }
        assertThat(splitStr).containsExactly("1", "2", "3");
    }

    @Test
    public void inputIsNULL() {
        // given
        Separators separators = new Separators();

        // when & then
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String string = separators.containCustomSeparator(null);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.NULL_INPUT.getMessage());
    }
}
