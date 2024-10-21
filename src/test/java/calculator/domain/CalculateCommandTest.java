package calculator.domain;


import calculator.business.command.CalculateCommand;
import calculator.domain.model.value.MajorData;
import calculator.domain.model.value.Separator;
import calculator.presentation.InputData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculateCommandTest {


    @DisplayName("// 와 \\n 안에 있는 문자를 커스텀 문자로 가질 수 있다")
    @Test
    void extractCustomSeparatorTest() {

        // given
        String data = "//w\\n1:2,3";
        InputData inputData = new InputData(data);

        // when
        CalculateCommand calculateCommand = new CalculateCommand(inputData);

        // then
        Assertions.assertThat(calculateCommand.customSeparators)
                .isEqualTo(new Separator("w"));
    }


    @DisplayName("문자열에서 // 부터 \\n 까지 제거한 후 반환한다")
    @Test
    void removeCustomInfoTest() {

        // given
        String data = "//w\\n1:2,3";
        InputData inputData = new InputData(data);

        // when
        CalculateCommand calculateCommand = new CalculateCommand(inputData);

        // then
        Assertions.assertThat(calculateCommand.majorData)
                .isEqualTo(new MajorData("1:2,3"));
    }
}

