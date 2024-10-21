package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = readLine();
        String sep = ",|;";
        int sum = 0;

        if (input.startsWith("//")) {
            sep = input.split("\n")[0].substring(1);
        }

        String[] strArr = input.split(sep);
        int[] intArr = new int[strArr.length];  // strArr int 형으로 변환해서 넣을 배열
        for (String s : strArr) {
            sum += Integer.parseInt(s);
        }

        System.out.println("결과 : " + sum);

    }
}
