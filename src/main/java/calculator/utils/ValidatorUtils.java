package calculator.utils;

import java.util.List;

public class ValidatorUtils {

    public static void validateNumbers(List<Double> numbers){
        for (Double number : numbers) {
            if(number <= 0){
                throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
            }
        }
    }
}
