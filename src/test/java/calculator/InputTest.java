package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputTest {

    Input input = new Input("1,2,3");

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
        Input input = new Input("//1\n2,3");

        // when
        boolean isStart = input.getInput().startsWith("//");
        boolean contains = input.getInput().contains("\n");

        // then
        assertThat(isStart).isTrue();
        assertThat(contains).isTrue();
    }
}
