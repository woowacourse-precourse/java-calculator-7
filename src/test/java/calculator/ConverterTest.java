package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    Converter converter = new Converter("[,:]","//","\n");

    @Test
    void 문자열_숫자들로_변환(){
        List<Integer> numbers = converter.convertNumbersFromString("1,2:3");
        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }
}
