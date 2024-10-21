package calculator;
import camp.nextstep.edu.missionutils.Console;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

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
        //구분자 파악하여 저장, 구분자 목록 배열 리턴
        char[] delims = getDelim(input);
        // 문자열에서 숫자들 분류해내서 배열에 저장하기
        getNumbers(input, delims);
        // 배열에 저장된 숫자들 모두 더하기
        answer = calc();
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
        // 문자열에서 숫자들 분류해내서 배열에 저장하기
        List<Integer> numbersList = new ArrayList<Integer>();
        String splitter = "";
        for (char c: delims) {
            String str = String.valueOf(c);
            splitter += (str+"|");
        }
        splitter = splitter.substring(0, splitter.length()-1);
        if (delims.length == 3) {
            input = input.substring(5);
        }
        String[] splArr = input.split(splitter);
        for (String strNum: splArr) {
            int num = Integer.parseInt(strNum);
            numbersList.add(num);
        }
        for (Integer num: numbersList) {
            System.out.println(num);
        }
        return numbersList;
    }

    public static int calc() {
        int ans = 0;

        return ans;
    }
}
