package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.provider.ValueSource;

class SeperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"//!\\n1,2!3v6", "12,4v16", "123v123"},delimiter = 'v')
    void 합계를_계산한다(String input,int expected){
        assertThat(Seperator.calculate(input)).isEqualTo(expected);
    }




}