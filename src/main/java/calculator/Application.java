package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;


public class Application {

    /**
     * 구분자와 양수로 구성된 문자열에서 숫자의 합을 계산합니다.
     *
     * @param s 합을 계산할 문자열
     * @return 합계
     */
    static int calculate(String s) {
        //System.out.println(s);

        String refinedString = s;
        String listOfDelimiters = ",|:";
        int sumResult = 0;

        if (s.equals("")) {
            return 0;
        }

        // 커스텀 구분자 처리
        if (s.startsWith("//")) {
            int endOfDelimeter = s.indexOf("\\n");
            listOfDelimiters += "|" + s.substring(2, endOfDelimeter);

            int startOfNumbers = endOfDelimeter + 2;
            refinedString = s.substring(startOfNumbers);
        }

        StringTokenizer st = new StringTokenizer(refinedString, listOfDelimiters);

        while (st.hasMoreElements()) {
            String token = String.valueOf(st.nextElement());

            sumResult += Integer.parseInt(token);
        }

        return sumResult;

    }

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String inputString = Console.readLine();

        calculate(inputString);
        //System.out.println("결과 : " + calculate(inputString));
    }
}
