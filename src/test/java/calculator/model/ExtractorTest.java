package calculator.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExtractorTest {
    @Test
    public void 구분자와_숫자_나누기(){
        //Given
        Extractor extractor = new Extractor();
        ExtractorDto extractorDto = new ExtractorDto();
        Delimiter delimiter = new Delimiter();
        String END_POINT_DELIMITER ="\n";
        String calculationValue = ";\n1;2;3";

        //When
        extractorDto = extractor.extractDelimiterAndNumber(extractorDto, delimiter, calculationValue, END_POINT_DELIMITER);

        //Then
        Assertions.assertThat(extractorDto.getDelimiters().size()).isEqualTo(1);
        Assertions.assertThat(extractorDto.getDelimiters().get(0)).isEqualTo(";");
        Assertions.assertThat(extractorDto.getValues()).isEqualTo("1;2;3");
    }
}
