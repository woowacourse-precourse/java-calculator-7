package calculator.model;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;


public class ExtractorTest {
    @Test
    public void 구분자와_숫자_나누기(){
        //Given
        SoftAssertions softly = new SoftAssertions();
        Extractor extractor = new Extractor();
        ExtractorDto extractorDto = new ExtractorDto();
        Delimiter delimiter = new Delimiter();
        String END_POINT_DELIMITER ="\n";
        String calculationValue = ";\n1;2;3";

        //When
        extractorDto = extractor.extractDelimiterAndNumber(extractorDto, delimiter, calculationValue, END_POINT_DELIMITER);

        //Then
        softly.assertThat(extractorDto.getDelimiters().size()).isEqualTo(1);
        softly.assertThat(extractorDto.getDelimiters().get(0)).isEqualTo(";");
        softly.assertThat(extractorDto.getValues()).isEqualTo("1;2;3");
        softly.assertAll();
    }


}
