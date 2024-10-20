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
        Console.close();

        if (!str.matches("([,:]?\\d([,:]\\d)*[,:]?)?|(//.+\\\\n).*")) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public Optional<String> checkCustomDelim() {
        if (!str.startsWith("//")) {
            delims = ",|:";
            return Optional.empty();
        }

        String customDelim = str.substring(2, str.indexOf("\\n"));
        delims = ",|:" + "|" + customDelim;
        return Optional.of(customDelim);
    }

    public int calculate() {
        checkCustomDelim();

        String str2;
        if (str.matches("//.+\\\\n.*")) {
            str2 = str.substring(str.indexOf("\\n") + 2);
        } else {
            str2 = str;
        }

        String[] nums;
        nums = str2.split(delims);
        int sum = 0;
        for (String num : nums) {
            try {
                int temp;
                if (num.equals("")) {
                    continue;
                } else {
                    temp = Integer.parseInt(num);
                    if (temp <= 0) {
                        throw new IllegalArgumentException();
                    }
                }

                sum += temp;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return sum;
    }
}
