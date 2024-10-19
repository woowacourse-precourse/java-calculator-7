package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTest {
    @Test
    @DisplayName("getNumber 테스트")
    public void getNumbersTest() throws Exception{

        Separator separator = new Separator();
        String testString = "//;\\n1;2";
        Numbers numbers1 = separator.getNumbers(testString);

        List<Double> numberList = new ArrayList<>();
        numberList.add(1.0);
        numberList.add(2.0);
        Numbers numbers2 = new Numbers(numberList);

        assertThat(numbers1.getSum()).isEqualTo(numbers2.getSum());
    }
}