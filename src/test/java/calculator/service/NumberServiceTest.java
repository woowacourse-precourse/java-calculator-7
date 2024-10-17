package calculator.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberServiceTest {
    @DisplayName("나눠진 문자열 조각에서 숫자를 추출한다.")
    @Test
    void extractNum(){
        ValueService.saveUserInput("//;\\n1");
        SeparatorService.makeUpSeparators();
        ValueService.separateInputString();
        NumberService.extractNum();
        int num = NumberService.getNumbers().get(0);
        assertThat(num).isEqualTo(1);
    }
}
