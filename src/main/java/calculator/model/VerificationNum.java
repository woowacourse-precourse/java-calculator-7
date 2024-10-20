package calculator.model;

import java.util.List;

public class VerificationNum {

    public static void verifyAndParseNums(List<String> parsedList) {
        parsedList.forEach(num -> {
            try {
                int parsedNum = Integer.parseInt(num);
                if (parsedNum <= 0) {
                    throw new IllegalArgumentException("숫자는 양수여야 합니다!");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 문자가 들어가있습니다!");
            }
        });
    }
}
