package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = readLine();
        String sep = ",|;";
        int sum = 0;

        if (input.contains("\\n")) {
            String[] splitStr = input.split("\\\\n");
            sep = Pattern.quote(splitStr[0].substring(2));
            input = splitStr[1];
        }

        String[] strArr = input.split(sep);
        int[] intArr = new int[strArr.length];

        try {
            for (int i = 0; i < strArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
                if (intArr[i] < 0) {
                    throw new IllegalArgumentException();
                }
                sum += intArr[i];
            }
            System.out.println("결과 : " + sum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }
}
