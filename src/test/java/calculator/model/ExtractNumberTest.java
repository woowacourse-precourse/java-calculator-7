package calculator.model;

import calculator.validator.CustomDelimiterValueValidator;
import calculator.validator.DefalutDelimiterValueValidator;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExtractNumberTest {

    AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName("기본 구분자를 사용하여 숫자를 정상적으로 추출하는지 테스트")
    void 기본_구분자_정상_입력_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when
        String[] result = extractNumber.extractNumberFromInput("1,2:3");

        //then
        Assertions.assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("기본 구분자를 사용한 잘못된 입력을 검증하는지 테스트")
    void 기본_구분자_잘못된_입력_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> extractNumber.extractNumberFromInput("1,2;3"));
    }

    @Test
    @DisplayName("커스텀 구분자를 사용하여 숫자를 정상적으로 추출하는지 테스트")
    void 커스텀_구분자_정상_입력_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when
        String[] result = extractNumber.extractNumberFromInput("//;\n1;2;3");

        //then
        Assertions.assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 잘못된 입력을 검증하는지 테스트")
    void 커스텀_구분자_잘못된_입력_테스트() {

        //given
        ExtractNumber extractNumber = appConfig.extractNumber();

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> extractNumber.extractNumberFromInput("//;\n1,2;3"));
    }

    class AppConfig {

        public ExtractNumber extractNumber() {
            return new ExtractNumber(delimiterValidator(), customDelimiterValueValidator(),
                    defalutDelimiterValueValidator());
        }

        private Validator delimiterValidator() {
            return new DelimiterValidator();
        }

        private Validator customDelimiterValueValidator() {
            return new CustomDelimiterValueValidator();
        }

        private Validator defalutDelimiterValueValidator() {
            return new DefalutDelimiterValueValidator();
        }
    }
}