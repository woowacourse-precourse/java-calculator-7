package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    static List<String> separator = new ArrayList<>(Arrays.asList(",", ":"));
    public static void main(String[] args) {
        try {
            String userInput = Console.readLine();
            userInput = addSeparator(userInput);
            int[] numbers = separatorNum(userInput);
            System.out.println("결과 : " + cal_sum(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String addSeparator(String userInput) {
        if (userInput.startsWith("//") && userInput.contains("\\n")) {
            String nsep = userInput.substring(2, userInput.indexOf("\\n"));
            if (nsep.matches(".*[0-9].*")) {
                throw new IllegalArgumentException("오류: 구분자에 숫자가 포함되어 있습니다.");
            }
            userInput = userInput.substring(userInput.indexOf("\\n")+2);

            separator.add(nsep);
        }
        return userInput;
    }

    public static int[] separatorNum(String userInput) {
        StringBuilder separator_sb = new StringBuilder();
        for (String str : separator) {
            if (!separator_sb.isEmpty()) {
                separator_sb.append("|");
            }
            separator_sb.append(Pattern.quote(str));
        }
        String[] strarr =  userInput.split(separator_sb.toString(), -1);
        int[] intarr = new int[strarr.length];


        for(int i = 0; i < intarr.length; i++) {
            try {
                intarr[i] = Integer.parseInt(strarr[i]);
                if (intarr[i] < 0) {
                    throw new IllegalArgumentException("오류: 음수는 허용되지 않습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("오류: 허용하지 않는 구분자를 사용하였습니다: " + strarr[i]);
            }
        }

        return intarr;
    }

    public static int cal_sum(int[] numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }

}
