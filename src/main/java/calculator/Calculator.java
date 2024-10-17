package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;

public class Calculator {
    private String str;
    private String delims;

    Calculator() {
        str = "";
        delims = ",|:";
    }

    public String inputStr() {
        str = Console.readLine().trim();
        return str;
    }

    public Optional<String> checkCustomDelim() {
        if (!str.startsWith("//")) {
            return Optional.empty();
        }

        String customDelim = str.substring(2, str.indexOf("\\n"));
        str = str.substring(str.indexOf("\\n") + 2);
        delims = delims.concat("|" + customDelim);
        return Optional.of(customDelim);
    }

    public int calculate() {
        String[] nums;
        nums = str.split(delims);
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
