package calculator.model;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void 더하기_계산이_올바르게_되는_지() {
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        Calculator calculator = new Calculator();
        String calculationValue1 = "//;\\n4;2;3";
        String calculationValue2 = "1:2,,3";
        Numbers numbers1 = extractor.extractValues(calculationValue1);
        Numbers numbers2 = extractor.extractValues(calculationValue2);

        //When
        int resultVaule1 = calculator.plusCalculator(numbers1);
        int resultVaule2 = calculator.plusCalculator(numbers2);

        //Then
        softly.assertThat(resultVaule1).isEqualTo(9);
        softly.assertThat(resultVaule2).isEqualTo(6);
    }
}
