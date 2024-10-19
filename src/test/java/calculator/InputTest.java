package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InputTest {


    @Test
    void inputSplit() {
        // given
        Separator separator = new Separator();

        // when
        final int[] numbers = separatorInput(separator);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    private int[] separatorInput(Separator separator) {
        Input input = new Input("1,2,3");
        String regex = separator.getRegex();
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
        Separator separator = new Separator();
        String splitInputWithSeparator = separator.containCustomSeparator("//;\\n1;2;3");
        Input input = new Input(splitInputWithSeparator);

        // when
        String[] splitStr = input.splitBySeparator(separator);

        // then
        for (int i = 0; i < splitStr.length; i++) {
            System.out.println(splitStr[i]);
        }
        assertThat(splitStr).containsExactly("1", "2", "3");
    }

    @Test
    public void inputIsNULL() {
        // given
        Separator separator = new Separator();

        // when & then
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String splitInputWithSeparator = separator.containCustomSeparator(null);
            Input input1 = new Input(splitInputWithSeparator);
        });
        assertThat(exception.getMessage()).isEqualTo("입력값이 null이 될 수 없습니다.");
    }
}
