package calculator.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExtractNumberTest {

    AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName("기본 구분자를 사용하여 숫자를 추출하는지 테스트")
    void 기본_구분자_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when
        String[] result = extractNumber.extractNumberFromInput("1,2:3");

        //then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 숫자를 추출하는지 테스트")
    void 커스텀_구분자_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when
        String[] result = extractNumber.extractNumberFromInput("//;\n1;2;3");

        //then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("잘못된 형식의 입력값이 들어왔을 때 예외를 발생시키는지 테스트")
    void 잘못된_형식_입력값_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when, then
        assertThrows(IllegalArgumentException.class, () -> extractNumber.extractNumberFromInput("//;\n1,2;3"));
    }

    class AppConfig {

        public ExtractNumber extractNumber() {
            return new ExtractNumber(delimiterValidator(), valueValidator());
        }

        private Validator delimiterValidator() {
            return new DelimiterValidator();
        }

        private Validator valueValidator() {
            return new ValueValidator();
        }
    }
}