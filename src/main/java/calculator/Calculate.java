package calculator;

import java.util.logging.Filter;

public class Calculate {
    public static int add(String[] speratedStrings) {
        int sum = 0;

        if (speratedStrings==null || speratedStrings.length==0) {
            return 0;
        }

        for (String str : speratedStrings) {

            if (str.startsWith("-")) {
                throw new IllegalArgumentException("잘못된 입력");
            }


            try {
                sum += Integer.parseInt(str.trim()); // trim()으로 공백 제거
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된입력.");
            }
        }

        return sum;
    }
}
