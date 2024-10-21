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
        String _string = separators.segregateByInput("1,2,3");
        Input input = new Input(_string);

        // when
        String[] splitStr = input.splitBySeparator(separators);

        // then
        assertThat(splitStr).containsExactly("1", "2", "3");
    }

    @Test
    void inputWithNoNumber() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput("");
        Input input = new Input(_string);

        // when
        String[] splitStr = input.splitBySeparator(separators);

        // then
        assertThat(splitStr).isEmpty();
    }

    @Test
    public void inputIsNULL() {
        // given
        Separators separators = new Separators();

        // when & then
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String _string = separators.segregateByInput(null);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.NULL_INPUT.getMessage());
    }

    @Test
    void inputSplitWithBasicSeparators() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput("1;2,3");
        Input input = new Input(_string);

        // when
        String[] splitStr = input.splitBySeparator(separators);

        // then
        assertThat(splitStr).containsExactly("1", "2", "3");
    }

    @Test
    public void inputWithDesignSeparators() {
        // given
        String input = "//;\\n2,3";

        // when
        boolean isStart = input.startsWith("//");
        boolean contains = input.contains("\\n");

        // then
        assertThat(isStart).isTrue();
        assertThat(contains).isTrue();
    }

    @Test
    public void separatorInputWithCostume() {
        // given
        Separators separators = new Separators();
        String splitInputWithSeparator = separators.segregateByInput("//;\\n1;2;3");
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
    public void inputWithNegativeNumber() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput("1,-2,3");
        Input input = new Input(_string);

        // when & then
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String[] splitStr = input.splitBySeparator(separators);
            input.convertToIntArray(splitStr);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.NEGATIVE_OR_ZERO_INPUT.getMessage());
    }

    @Test
    public void inputWithBlank() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput(" 1 , 2 , 3 ");
        Input input = new Input(_string);
        String[] splitString = input.splitBySeparator(separators);

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input.convertToIntArray(splitString);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.VALID_NUMBER.getMessage());
    }

    @Test
    public void inputWithNotCollectBasicSeparator() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput("//;\\n\\n1;2;3");
        Input input = new Input(_string);
        String[] splitString = input.splitBySeparator(separators);

        // when & then
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            input.convertToIntArray(splitString);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.VALID_NUMBER.getMessage());
    }

    @Test
    public void inputWithZeroNumber() {
        // given
        Separators separators = new Separators();
        String _string = separators.segregateByInput("//;\\n0;1;2;3");
        Input input = new Input(_string);

        // when & then
        // IllegalArgumentException 발생
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String[] splitStr = input.splitBySeparator(separators);
            input.convertToIntArray(splitStr);
        });
        assertThat(exception.getMessage()).isEqualTo(ExceptionCode.NEGATIVE_OR_ZERO_INPUT.getMessage());
    }
}
