package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        int result;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            result = checkString(input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하여 프로그램이 종료됩니다.");
            return;
        }
        System.out.println("결과 : " + result);
    }


    public static int checkString(String input) {
        int answer = 0;
        if (input.equals("")) {
            return 0;
        }
        //구분자 파악하여 저장, 구분자 목록 배열 리턴
        char[] delims = getDelim(input);
        // 문자열에서 숫자들 분류해내서 배열에 저장하기
        List<Integer> numbers = getNumbers(input, delims);
        // 배열에 저장된 숫자들 모두 더하기
        answer = calc(numbers);
        return answer;
    }

    public static char[] getDelim(String input) {
        char[] delim;
        String c1 = "//";
        String c2 = "\\n";

        String customChecker1 = input.substring(0,2);
        String customChecker2 = input.substring(3,5);

        if (customChecker1.equals(c1) && customChecker2.equals(c2)) { // 정상적인 구분자입력의 경우
            delim = new char[3];
            if (48 <= input.charAt(2) && input.charAt(2) <= 57) { // 구분자 입력을 숫자로 한 경우
                throw new IllegalArgumentException("잘못된 입력 값입니다: 구분자가 숫자입니다.");
            }
            delim[2] = input.charAt(2);
        }
        else if (customChecker1.equals(c1) && input.contains(c2)) { // 커스텀문자열이 2자 이상
            throw new IllegalArgumentException("잘못된 입력 값입니다: 커스텀 문자열이 2자 이상입니다.");
        }
        else { // 커스텀구분자 없음
            delim = new char[2];
        }
        delim[0] = ',';
        delim[1] = ':';
        return delim;
    }

    public static List<Integer> getNumbers(String input, char[] delims) {
        List<Integer> numbersList = new ArrayList<Integer>();
        String splitter = "";

        for (char c: delims) {
            String str = String.valueOf(c);
            splitter += str;
        }
        if (delims.length == 3) {
            input = input.substring(5);
        }
        StringTokenizer st = new StringTokenizer(input, splitter);
        List<String> splArr = new ArrayList<String>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            splArr.add(token);
        }
        for (String strNum: splArr) {
            int num = Integer.parseInt(strNum);
            numbersList.add(num);
        }
        return numbersList;
    }

    public static int calc(List<Integer> numbers) {
        int ans = 0;
        for (Integer num: numbers) {
            ans += num;
        }
        return ans;
    }
}
