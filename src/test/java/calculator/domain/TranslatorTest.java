package calculator.domain;

import calculator.domain.model.Translator;
import calculator.domain.model.value.MajorData;
import calculator.domain.model.value.PositiveNumber;
import calculator.domain.model.value.Separator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class TranslatorTest {


    @DisplayName("1,2:3 을 입력하면 1, 2, 3 으로 각각 변환한다")
    @Test
    void parseTest() {

        // given
        Translator translator = new Translator(new Separator());
        String data = "1,2:3";

        // when
        List<PositiveNumber> positiveNumbers = translator.translate(new MajorData(data));

        // then
        Assertions.assertThat(positiveNumbers)
                .extracting(PositiveNumber::value)
                .containsExactly(1L, 2L, 3L);
    }


    @DisplayName("커스텀 구분자가 ; 인 경우 1,2:3;4 를 입력하면 1, 2, 3, 4 로 각각 변환한다")
    @Test
    void addCustomSeparatorsTest() {

        // given
        Translator translator = new Translator(new Separator(";"));
        String data = "1,2:3;4";

        // when
        List<PositiveNumber> positiveNumbers = translator.translate(new MajorData(data));

        // then
        Assertions.assertThat(positiveNumbers)
                .extracting(PositiveNumber::value)
                .containsExactly(1L, 2L, 3L, 4L);


    }
}
