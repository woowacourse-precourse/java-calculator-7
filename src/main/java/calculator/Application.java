package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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
        getDelim();
        // 문자열에서 숫자들 분류해내서 배열에 저장하기
        getNumbers();
        // 배열에 저장된 숫자들 모두 더하기
        answer = calc();
        return answer;
    }

    public static char[] getDelim() {
        char[] delim = new char[3];

        return delim;
    }

    public static List<Integer> getNumbers() {
        List<Integer> l = new ArrayList<>();

        return l;
    }

    public static int calc() {
        int ans = 0;

        return ans;
    }
}
