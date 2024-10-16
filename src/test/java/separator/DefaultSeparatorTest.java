package separator;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultSeparatorTest {

    @DisplayName("문자열에 포함된 숫자를 가져올 수 있다.")
    @Test
    void getNumbers() {
        //given
        DefaultSeparator defaultSeparator = new DefaultSeparator(List.of(",", ":"));
        String str = "123123,121,1253123:12541";
        Calculator calculator = new Calculator(defaultSeparator);
        Separator separator = calculator.generateSeparators(str);

        //when
        List<BigInteger> numbers = separator.getNumbers();

        //then
        Assertions.assertThat(numbers.get(0)).isEqualTo(123123);

    }
}