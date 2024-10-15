package calculator;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class Application {
    private static final String 구분자 = "([,:])";

    public static void main(String[] args) {
        System.out.printf("결과: " + execute(Console.readLine()));
    }

    private static String execute(String input) {
        int sum = 0;
        if (StringUtils.isBlank(input)) {
            return String.valueOf(sum);
        }

        return String.valueOf(sum(input.split(구분자)));
    }

    private static int sum(String[] strings) {
        int sum = 0;
        for (String str : strings) {
            sum += Integer.parseUnsignedInt(str);
        }

        return sum;
    }
}
