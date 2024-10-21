package calculator;
import org.junit.jupiter.api.Test;

import static calculator.Converter.removeCustomDelimiterAndSpace;
import static calculator.Validator.findCustomDelimiter;

class ConverterTest {
    @Test
    void testRemoveDelimiter() {
        String target = "//_ :,: \n1_4:6,5";
        String delimiter = findCustomDelimiter(target);
        target = removeCustomDelimiterAndSpace(target, delimiter);
        String answer = "1_4:6,5";
        assert answer.equals(target);
    }

    @Test
    void testConverter() {
        String target = "//_ :,: \n1_4:6,5";
        String delimiter = findCustomDelimiter(target);
        target = removeCustomDelimiterAndSpace(target, delimiter);

        String[] strings = Converter.convertToArray(target);
        String[] answer = {"1", "4", "6", "5"};

        assert strings.length == answer.length;
        for (int i = 0; i < answer.length; i++) {
            assert answer[i].equals(strings[i]);
        }
    }

}