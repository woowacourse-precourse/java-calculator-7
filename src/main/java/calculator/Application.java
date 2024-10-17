package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        // TODO: 프로그램 구현

        // 입력을 요청하는 문자열 출력
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 입력 받아서 String에 저장
        String string = Console.readLine();

        // 답을 저장할 int 변수 생성
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<string.length();i++) {
            char c= string.charAt(i);
            int n = c-'0';
            if (0<=n && n<=9) {
                sb.append(c);
            } else if (c==',' || c==':'){
                if (!sb.isEmpty()) {
                    answer += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (!sb.isEmpty()) {
            answer += Integer.parseInt(sb.toString());
        }
        System.out.println(answer);
    }
}
