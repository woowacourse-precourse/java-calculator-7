package calculator.service;

import calculator.domain.Separator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeparatorServiceTest {

    @DisplayName("커스텀 구분자가 있다면 true를 반환한다.")
    @Test
    void checkCustomSeparator(){
        boolean customSeparator = SeparatorService.isCustomSeparatorExist("//;\\n1");
        assertThat(customSeparator).isEqualTo(true);
    }

    @DisplayName("커스텀 구분자를 알아낸다.")
    @Test
    void getCustomSeparator(){
        String customSeparator = SeparatorService.extractCustomSeparator("//;\\n1");
        assertThat(customSeparator).isEqualTo(";");
    }

    @DisplayName("커스텀 구분자를 구분자에 추가한다.")
    @Test
    void addSeparator(){
        SeparatorService.addSeparator(";");
        String separators = Separator.getSeparators();
        assertThat(separators).isEqualTo("[,:]|;");
    }

    @DisplayName("커스텀 구분자를 가져온다.")
    @Test
    void getSeparator(){
        Separator.addSeparator(";");
        String separators = SeparatorService.getSeparators();
        assertThat(separators).isEqualTo("[,:]|;");
    }
}
