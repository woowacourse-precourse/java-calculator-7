package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest {

    Input input = new Input("1,2,3");

    @Test
    void inputSplit() {
        // given

        List<String> separator = Arrays.asList(",", ";");

        // when
        final int[] numbers = separatorInput(separator);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    private int[] separatorInput(List<String> separator) {
        String regex = String.join("|", separator);
        String[] splitStr = input.getInput().split(regex);

        int[] numbers = new int[splitStr.length];
        for (int i = 0; i < splitStr.length; i++) {
            numbers[i] = Integer.parseInt(splitStr[i]);
        }
        return numbers;
    }
}
