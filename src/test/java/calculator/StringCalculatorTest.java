package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자가 입력한 문자열에서 숫자를 추출하여 더하는 계산하는 기능 테스트")
class StringCalculatorTest {
    private final String defaultRegex = "[:.]";
    private String customRegex;
    private final String isPositiveNumberRegex = "^[^0]\\d*";

    private int result;
    
    @ParameterizedTest
    @MethodSource("validInputs")
    @DisplayName("올바른 입력")
    void run(String input,int result) {
        setThirdDelimiterAndCalculate(new UserInput(input));
        assertThat(this.result).isEqualTo(result);
    }
    
    @ParameterizedTest
    @MethodSource("invalidInputs")
    @DisplayName("예외 테스트")
    void exceptionTest(String input,int result) {
        assertThatThrownBy(() ->setThirdDelimiterAndCalculate(new UserInput(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void setThirdDelimiterAndCalculate(UserInput userInput) {
        if(userInput.isCustomDelimiterPresent()) {
            String customDelimiter = userInput.getCustomDelimiter();
            customRegex = "[:."+customDelimiter+"]";
            calculate(userInput.getNumberString(), customRegex);
        }
        else {
            calculate(userInput.getNumberString(),defaultRegex);
        }
    }

    private void calculate(String numberString,String regex) {
        int sum = 0;
        String[] split = numberString.split(regex);
        validateNumberString(split);
        try {
            for(String num : split) {
                sum += Integer.parseInt(num);
            }
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닌 문자열입니다.");
        }
        result = sum;
    }


    private void validateNumberString(String[] split) {
        Optional<String> any = Arrays.stream(split).filter(num -> !num.matches(isPositiveNumberRegex)).findAny();
        if (any.isPresent() || split.length==0) {
            throw new IllegalArgumentException("숫자 섹션에 구분자외 문자나 0으로 시작하는 숫자가 존재합니다.");
        }
    }

    static Stream<Object[]> validInputs() {
        return Stream.of(new Object[]{"//#\\n4.5#6:7",22},
                new Object[]{"//@\\n7@8:9.10",34},
                new Object[]{"//^\\n7^8.9:10",34},
                new Object[]{"//&\\n1:2&3",6},
                new Object[]{"1:2.3",6});
    }
    static Stream<Object[]> invalidInputs() {
        return Stream.of(new Object[]{"//;\\n1:2.3,4",10},
                new Object[]{"//^\\n1:2*3",6},
                new Object[]{"//.\\n1:2.3",6},
                new Object[]{"//:\\n1:2.3",6},

                new Object[]{"\\:\\n1:2.3",6},

                new Object[]{"1:2&3",6},

                new Object[]{"//&\n1:2.3",6},
                new Object[]{"//^\n\n1:2:3",6},
                new Object[]{"//*\r*",6},

                new Object[]{"",0},
                new Object[]{"\\n",0},
                new Object[]{"0",0}
                );
    }
}