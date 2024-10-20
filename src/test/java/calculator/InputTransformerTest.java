package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTransformerTest {

    @Test
    void transEmptyTest() {
        InputTransformer inputTransformer = new InputTransformer();
        int[] result;

        result = inputTransformer.stringToIntArray("", DelimiterType.EMPTY);
        assertThat(result).isEqualTo(new int[]{});

    }

    @Test
    void transDefaultDelimiterTest() {
        InputTransformer inputTransformer = new InputTransformer();
        int[] result;

        result = inputTransformer.stringToIntArray("1,2,3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("1:2:3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("1,2:3", DelimiterType.DEFAULT);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

    }

    @Test
    void transCustomDelimiterTest() {
        InputTransformer inputTransformer = new InputTransformer();
        int[] result;

        result = inputTransformer.stringToIntArray("//;\\n1", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{1});

        result = inputTransformer.stringToIntArray("//;\\n1;2;3", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("//3\\n333", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{});

        result = inputTransformer.stringToIntArray("//3\\n43331", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{4, 0, 0, 1});

        result = inputTransformer.stringToIntArray("//o\\n1o2o3", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{1, 2, 3});

        result = inputTransformer.stringToIntArray("//-3\\n2-33-32", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{2, 3, 2});

        result = inputTransformer.stringToIntArray("// \\n2 3 4", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{2, 3, 4});

        result = inputTransformer.stringToIntArray("//  \\n2  3  4", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{2, 3, 4});

        result = inputTransformer.stringToIntArray("//abcd\\n2abcd3abcd4", DelimiterType.CUSTOM);
        assertThat(result).isEqualTo(new int[]{2, 3, 4});


    }
}