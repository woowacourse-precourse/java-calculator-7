package calculator;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        int result;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        result = checkString(input);
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

        if (customChecker1.equals(c1) && (customChecker2.equals(c2))) {
            delim = new char[3];
            delim[2] = input.charAt(2);
        }
        else {
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
