package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SpliteratorTest {

    @Test
    void split() {
        String[] result = split("[,:]", "1,2,3");
        Assertions.assertThat(result).isEqualTo((new String[]{"1", "2", "3"}));
    }

    @Test
    void customSplit() {
        String[] result = split("[,:]", "1;2;3:4:5", ";");
        Assertions.assertThat(result).isEqualTo(new String[]{"1", "2", "3", "4", "5"});
    }

    @Test
    void customSplit1() {
        String[] result = split("[,:]", "1d2d3d4", "d");
        Assertions.assertThat(result).isEqualTo(new String[]{"1", "2", "3", "4"});
    }

    private static String[] split(String regex, String input) {
        Spliterator spliterator = new Spliterator(regex);
        return spliterator.split(input);
    }

    private static String[] split(String regex, String input, String extraRegex) {
        Spliterator spliterator = new Spliterator(regex);
        return spliterator.split(input, extraRegex);
    }
}