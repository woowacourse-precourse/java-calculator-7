package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    //2 번 해결
    public int solution(String str) {
        int answer = 0;
        String[] arr = str.split(",|:");
        for (String x : arr) {
            answer += Integer.parseInt(x);
        }
        return answer;
    }


    public static void main(String[] args) {
        Application app = new Application();
        // 사용자의 입력을 받는다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        System.out.print("결과 : " + app.solution(str));
    }
}
