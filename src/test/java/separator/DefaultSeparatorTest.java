package separator;

import calculator.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

class DefaultSeparatorTest {

    @DisplayName("인풋값을 구분자로 자른 값을 가져올 수 있다.")
    @Test
    void splitInputDataBySeparator() {
        //given
        List<String> defaultSeparator = List.of(",", ":");
        String str = "123123,121,1253123:12541";
        Calculator calculator = new Calculator(defaultSeparator,str);
        Separator separator = calculator.generateSeparators(str);

        //when
        String[] split = separator.splitInputDataBySeparator();

        //then
        Assertions.assertThat(split[0]).isEqualTo("123123");

    }
}