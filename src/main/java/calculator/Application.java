package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int getSum(String str, String separator) {
        String regex = "[" + separator + "]";
        String[] array = str.split(regex);

        int result = 0;
        for (String s : array) {
            result += Integer.parseInt(s);
        }

        return result;
    }

    public static void main(String[] args) {
        String sep = ",:";
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str.startsWith("//")) {
            int idx = str.indexOf("\\n");
            // 문자열 추출 후 새 구분자 문자열, 새 검사 문자열 선언
            String newSeparator = sep + str.substring(2, idx);
            String newStr = str.substring(idx + 2);

            System.out.println("결과 : " + getSum(newStr, newSeparator));
        } else {
            System.out.println("결과 : " + getSum(str, sep));
        }

    }
}
