package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class SumValuesTest {

    @Test
    @DisplayName("SumValues는_리스트_내_SumValue_값의_총합을_반환한다")
    public void sumAll() {
        //given
        SumValues sumValues = new SumValues(
                Arrays.asList(
                        new SumValue(1),
                        new SumValue(2),
                        new SumValue(3),
                        new SumValue(4)
                )
        );

        //when
        int result = sumValues.sumAll();

        //then
        assertThat(result).isEqualTo(10);
    }
}