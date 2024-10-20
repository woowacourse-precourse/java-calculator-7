package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    static List<String> separator = new ArrayList<>(Arrays.asList(",", ":"));
    public static void main(String[] args) {
            String userInput = Console.readLine();
            userInput = addSeparator(userInput);
            int[] numbers = separateNum(userInput);
            System.out.println("결과 : " + calculateSum(numbers));
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

    public static int[] separateNum(String userInput) {
        if(userInput.equals("")){
            return new int[]{0};
        }
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
                throw new IllegalArgumentException("오류: 입력값이 올바르지 않습니다.");
            }
        }

        return intarr;
    }

    public static int calculateSum(int[] numbers) {
        int sum = 0;
        for(int i : numbers) {
            sum += i;
        }
        return sum;
    }

}
