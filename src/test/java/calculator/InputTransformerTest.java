package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTransformerTest {

    @Test
    void transDefaultDelimiterTest(){
        InputTransformer inputTransformer = new InputTransformer();
        int[] result;

        result = inputTransformer.stringToIntArray("1,2,3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("1:2:3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("1,2:3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

    }
}