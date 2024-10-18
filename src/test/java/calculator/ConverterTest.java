package calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    Converter converter = new Converter("[,:]","//","\\n");

    @Test
    void 기본_구분자로_숫자_분리(){
        List<Integer> numbers = converter.convertNumbersFromString("1,2:3");
        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }

    @Test
    void 커스텀_구분자로_숫자_분리(){
        List<Integer> numbers = converter.convertNumbersFromString("//;\\n1,2;3");
        assertThat(numbers).isEqualTo(List.of(1,2,3));
    }
}
